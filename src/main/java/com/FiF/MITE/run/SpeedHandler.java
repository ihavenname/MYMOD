//package com.FiF.MITE.run;
//
//import com.FiF.MITE.BreakBlcok.KeyBinds.KeyBindings;
//import net.minecraft.client.Minecraft;
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.effect.MobEffects;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.phys.Vec3;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.client.event.InputEvent;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.event.entity.living.LivingEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = "mite", value = Dist.CLIENT)
//public class SpeedHandler {
//
//    private static boolean speedActive = false;
//
//    // 可调参数
//    private static final double HORIZONTAL_JUMP_BOOST = 0.27; // 水平跳跃动量
//    private static final int SPEED_EFFECT_LEVEL = 0;          // MOVEMENT_SPEED 等级
//
//    public static boolean isSpeedActive() {
//        return speedActive;
//    }
//
//    // 按键切换速度开关
//    @SubscribeEvent
//    public static void onKeyPress(InputEvent.Key event) {
//        Minecraft mc = Minecraft.getInstance();
//        if (mc.player == null) return;
//
//        if (KeyBindings.SPEED_TOGGLE.isDown()) {
//            int food = mc.player.getFoodData().getFoodLevel();
//            if (food > 0 && food <= 6) {
//                speedActive = !speedActive; // 切换开关
//            } else if (food > 6) {
//                speedActive = false; // 饱食度>6直接取消
//            }
//        }
//    }
//
//    // 玩家 Tick，处理移动速度
//    @SubscribeEvent
//    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
//        Player player = event.player;
//        int food = player.getFoodData().getFoodLevel();
//
//        if (speedActive && food > 0 && food <= 6) {
//            // 仅在开关激活时增加移动速度
//            if (!player.hasEffect(MobEffects.MOVEMENT_SPEED)) {
//                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, SPEED_EFFECT_LEVEL, false, false, false));
//            }
//        } else {
//            // 取消速度效果
//            if (player.hasEffect(MobEffects.MOVEMENT_SPEED)) {
//                player.removeEffect(MobEffects.MOVEMENT_SPEED);
//            }
//            speedActive = false;
//        }
//    }
//
//    // 玩家跳跃事件，增强水平跳跃距离，仅在前进时触发
//    @SubscribeEvent
//    public static void onPlayerJump(LivingEvent.LivingJumpEvent event) {
//        if (!(event.getEntity() instanceof Player player)) return;
//
//        if (!SpeedHandler.isSpeedActive()) return;
//
//        Minecraft mc = Minecraft.getInstance();
//        if (mc.player != player) return;
//
//        // 只在按下前进键（W）时增强水平跳跃
//        if (mc.options.keyUp.isDown()) {
//            float yaw = player.getYRot();
//            double rad = Math.toRadians(yaw);
//
//            double dx = player.getDeltaMovement().x + (-Math.sin(rad)) * HORIZONTAL_JUMP_BOOST;
//            double dz = player.getDeltaMovement().z + (Math.cos(rad)) * HORIZONTAL_JUMP_BOOST;
//
//            // 垂直方向保持原版跳跃高度
//            double dy = player.getDeltaMovement().y;
//
//            player.setDeltaMovement(dx, dy, dz);
//        }
//    }
//
//    // FOV 暂时注释掉
////    @SubscribeEvent
////    public static void onComputeFov(ComputeFovModifierEvent event) {
////        if (event.getPlayer().isLocalPlayer() && SpeedHandler.isSpeedActive()) {
////            event.setNewFovModifier(event.getFovModifier() * SPEED_MULTIPLIER);
////        }
////    }
//}
