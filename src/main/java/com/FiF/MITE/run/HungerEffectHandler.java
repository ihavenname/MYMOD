//package com.FiF.MITE.run;
//
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.effect.MobEffect;
//import net.minecraft.world.effect.MobEffects;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//import static com.FiF.MITE.run.SpeedHandler2.speedActive;
//
//@Mod.EventBusSubscriber(modid = "mite")
//public class HungerEffectHandler {
//
//    // 由 SpeedHandler2 控制的全局加速开关
//
//    @SubscribeEvent
//    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
//        if (!(event.player instanceof ServerPlayer player)) return;
//
//        if (speedActive) {
//            // 如果玩家还没有 Hunger 效果，就给效果
//            if (!player.hasEffect(MobEffects.HUNGER)) {
//                // 使用服务端添加效果，持续时间长，等级0
//                player.addEffect(new net.minecraft.world.effect.MobEffectInstance(
//                        MobEffects.HUNGER,
//                        999_999 * 20, // tick，999999秒
//                        39,            // Hunger等级0
//                        false,        // 是否显示粒子
//                        false,        // 是否显示HUD图标
//                        true          // 使用Effect命令模式（和 /effect 一样）
//                ));
//            }
//        } else {
//            // speedActive false → 移除效果
//            if (player.hasEffect(MobEffects.HUNGER)) {
//                player.removeEffect(MobEffects.HUNGER);
//            }
//        }
//    }
//}
