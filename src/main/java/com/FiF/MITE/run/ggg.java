//package com.FiF.MITE.run;
//
//import net.minecraft.world.entity.player.Player;
//import net.minecraftforge.event.entity.player.PlayerEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber
//public class SprintFoodOverride {
//
//    @SubscribeEvent
//    public static void onCanSprint(PlayerEvent.CanPlayerSprint event) {
//        Player player = event.getEntity();
//
//        // 当前饱食度
//        int food = player.getFoodData().getFoodLevel();
//
//        // 只要 > 0 就允许疾跑
//        if (food > 0) {
//            event.setCanSprint(true);
//        }
//    }
//}
