//package com.FiF.MITE.run;
//
//import com.FiF.MITE.run.network.SpeedStateHandler;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.food.FoodData;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = "mite")
//public class SpeedExhaustionHandler {
//
//    // 每 tick 的消耗
//    // 原版疾跑 = 0.1F
//    // 你这个是“硬核冲刺”，建议 1.2~2.0 倍
//    private static final float SPEED_EXHAUSTION_PER_TICK = 0.15F;
//
//    @SubscribeEvent
//    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
//        if (!(event.player instanceof ServerPlayer player)) return;
//        if (event.phase != TickEvent.Phase.END) return;
//
//        // ⭐ 只看服务器权威 speed 状态
//        if (SpeedStateHandler.isLocalSpeedActive(player)) {
//            FoodData food = player.getFoodData();
//            food.addExhaustion(SPEED_EXHAUSTION_PER_TICK);
//        }
//    }
//}
