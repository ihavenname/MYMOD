//package com.FiF.MITE.run;
//
//import com.FiF.MITE.BreakBlcok.KeyBinds.KeyBindings;
//import com.FiF.MITE.run.network.MITENetwork;
//import com.FiF.MITE.run.network.SpeedJumpPacket;
//import net.minecraft.client.Minecraft;
//import net.minecraft.world.entity.ai.attributes.AttributeModifier;
//import net.minecraft.world.entity.ai.attributes.Attributes;
//import net.minecraft.world.entity.player.Player;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.event.entity.living.LivingHurtEvent;
//import net.minecraftforge.event.entity.living.LivingEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//import java.util.UUID;
//
//@Mod.EventBusSubscriber(modid = "mite", value = Dist.CLIENT)
//public class SpeedHandler3 {
//
//    public static boolean speedActive = false;
//
//    private static final double HORIZONTAL_JUMP_BOOST = 0.27;
//    private static final double SPEED_MULTIPLIER = 1.3;
//    private static final UUID SPEED_MODIFIER_UUID =
//            UUID.fromString("5f5c5e2c-4f3f-4fcd-9c23-123456789abc");
//
//    public static boolean isSpeedActive() {
//        return speedActive;
//    }
//
//    // ================== 移动速度控制 ==================
//
//    @SubscribeEvent
//    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
//        Minecraft mc = Minecraft.getInstance();
//        Player player = event.player;
//        if (player != mc.player) return;
//
//        int food = player.getFoodData().getFoodLevel();
//
//        // 你自己的加速键
//        boolean speedKeyDown = KeyBindings.SPEED_TOGGLE.isDown();
//        boolean forwardKeyDown = mc.options.keyUp.isDown(); // W 键
//
//        // 饱食度 > 6 禁用 speed
//        if (food > 6) {
//            disableSpeed(player);
//            return;
//        }
//
//        // 启动 speed
//        if (speedKeyDown && food > 1 && !player.horizontalCollision) {
//            if (!speedActive) {
//                speedActive = true;
//                applySpeedModifier(player);
//            }
//        }
//
//        // 停止 speed
//        if (speedActive && (food <= 1 || player.horizontalCollision || !forwardKeyDown || !speedKeyDown)) {
//            disableSpeed(player);
//        }
//    }
//
//    private static void applySpeedModifier(Player player) {
//        if (player.getAttribute(Attributes.MOVEMENT_SPEED).getModifier(SPEED_MODIFIER_UUID) == null) {
//            AttributeModifier modifier = new AttributeModifier(
//                    SPEED_MODIFIER_UUID,
//                    "Custom Speed Boost",
//                    SPEED_MULTIPLIER - 1.0,
//                    AttributeModifier.Operation.MULTIPLY_TOTAL
//            );
//            player.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
//        }
//    }
//
//    private static void disableSpeed(Player player) {
//        if (!speedActive) return;
//        speedActive = false;
//
//        if (player.getAttribute(Attributes.MOVEMENT_SPEED).getModifier(SPEED_MODIFIER_UUID) != null) {
//            player.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(SPEED_MODIFIER_UUID);
//        }
//    }
//
//    // ================== 跳跃增强 ==================
//
//    @SubscribeEvent
//    public static void onPlayerJump(LivingEvent.LivingJumpEvent event) {
//        if (!(event.getEntity() instanceof Player player)) return;
//        if (!speedActive) return;
//
//        Minecraft mc = Minecraft.getInstance();
//        if (mc.player != player) return;
//
//        if (mc.options.keyUp.isDown()) {
//            float yaw = player.getYRot();
//            double rad = Math.toRadians(yaw);
//
//            double dx = player.getDeltaMovement().x + (-Math.sin(rad)) * HORIZONTAL_JUMP_BOOST;
//            double dz = player.getDeltaMovement().z + (Math.cos(rad)) * HORIZONTAL_JUMP_BOOST;
//            double dy = player.getDeltaMovement().y;
//
//            player.setDeltaMovement(dx, dy, dz);
//
//            // 发送服务器消耗包
//            MITENetwork.CHANNEL.sendToServer(new SpeedJumpPacket());
//        }
//    }
//
//    // ================== 受伤打断 ==================
//
//    @SubscribeEvent
//    public static void onPlayerHurt(LivingHurtEvent event) {
//        if (!(event.getEntity() instanceof Player player)) return;
//        if (!speedActive) return;
//
//        disableSpeed(player);
//    }
//}
