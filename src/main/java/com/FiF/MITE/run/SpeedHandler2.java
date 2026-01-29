package com.FiF.MITE.run;

import com.FiF.MITE.run.network.MITENetwork;
import com.FiF.MITE.run.network.SpeedJumpPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = "mite", value = Dist.CLIENT)
public class SpeedHandler2 {

    public static boolean speedActive = false;

    private static final double HORIZONTAL_JUMP_BOOST = 0.27; // 水平跳跃动量
    private static final double SPEED_MULTIPLIER = 1.3;      // 移动速度倍率
    private static final UUID SPEED_MODIFIER_UUID = UUID.fromString("5f5c5e2c-4f3f-4fcd-9c23-123456789abc");

    public static boolean isSpeedActive() {
        return speedActive;
    }

    // 玩家 Tick，处理移动速度
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = event.player;
        if (player != mc.player) return;

        int food = player.getFoodData().getFoodLevel();
        boolean sprintKeyDown = com.FiF.MITE.BreakBlcok.KeyBinds.KeyBindings.SPEED_TOGGLE.isDown();
        boolean forwardKeyDown = mc.options.keyUp.isDown(); // W 键

        // 饱食度大于 6 → 禁用加速功能
        if (food > 21) {
            if (speedActive) {
                speedActive = false;
                if (player.getAttribute(Attributes.MOVEMENT_SPEED).getModifier(SPEED_MODIFIER_UUID) != null) {
                    player.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(SPEED_MODIFIER_UUID);
                }
            }
            return; // 直接退出，不再触发加速
        }

        // 触发加速：按下 Sprint 并且饱食度 ≤ 6，并且未撞墙
        if (sprintKeyDown && food > 1 && !player.horizontalCollision) {
            if (!speedActive) {
                speedActive = true;
                if (player.getAttribute(Attributes.MOVEMENT_SPEED).getModifier(SPEED_MODIFIER_UUID) == null) {
                    AttributeModifier modifier = new AttributeModifier(
                            SPEED_MODIFIER_UUID,
                            "Custom Speed Boost",
                            SPEED_MULTIPLIER - 1.0,
                            AttributeModifier.Operation.MULTIPLY_TOTAL
                    );
                    player.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
                }
            }
        }

        // 取消加速条件：饱食度 0、撞墙、松开 W
        if (speedActive && (food <= 1 || player.horizontalCollision || !forwardKeyDown)) {
            speedActive = false;
            if (player.getAttribute(Attributes.MOVEMENT_SPEED).getModifier(SPEED_MODIFIER_UUID) != null) {
                player.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(SPEED_MODIFIER_UUID);
            }
        }
    }

    // 玩家跳跃事件，增强水平跳跃距离，仅在前进键按下时
    @SubscribeEvent
    public static void onPlayerJump(LivingEvent.LivingJumpEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!speedActive) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.player != player) return;

        if (mc.options.keyUp.isDown()) {// 仅按前进键时
            float yaw = player.getYRot();
            double rad = Math.toRadians(yaw);

            double dx = player.getDeltaMovement().x + (-Math.sin(rad)) * HORIZONTAL_JUMP_BOOST;
            double dz = player.getDeltaMovement().z + (Math.cos(rad)) * HORIZONTAL_JUMP_BOOST;
            double dy = player.getDeltaMovement().y;

            player.setDeltaMovement(dx, dy, dz);
            MITENetwork.CHANNEL.sendToServer(new SpeedJumpPacket());
        }
    }

    // 受伤取消加速
    @SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!speedActive) return;

        // 玩家受伤立即取消加速
        speedActive = false;
        if (player.getAttribute(Attributes.MOVEMENT_SPEED).getModifier(SPEED_MODIFIER_UUID) != null) {
            player.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(SPEED_MODIFIER_UUID);
        }
    }

    // FOV 暂时注释掉
//    @SubscribeEvent
//    public static void onComputeFov(ComputeFovModifierEvent event) {
//        if (event.getPlayer().isLocalPlayer() && speedActive) {
//            event.setNewFovModifier(event.getFovModifier() * SPEED_MULTIPLIER);
//        }
//    }
}
