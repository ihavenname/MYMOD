//package com.FiF.MITE.run;
//
//import com.FiF.MITE.MITE;
//import net.minecraft.world.entity.player.Player;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = MITE.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
//public class LowFoodSprint {
//
//    @SubscribeEvent
//    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
//        if (event.phase != TickEvent.Phase.END) return;
//
//        Player player = event.player;
//
//        // 创造和旁观不处理
//        if (player.isCreative() || player.isSpectator()) return;
//
//        // 饱食度
//        int food = player.getFoodData().getFoodLevel();
//
//        // 没有食物时禁止疾跑
//        if (food <= 0) return;
//
//        // 是否在向前移动（客户端发来的输入）
//        boolean movingForward = player.zza > 0;
//
//        // 是否潜行
//        boolean sneaking = player.isShiftKeyDown();
//
//        // 只要在尝试前进且没潜行，就强制允许疾跑
//        if (movingForward && !sneaking) {
//            player.setSprinting(true);
//        }
//    }
//}
