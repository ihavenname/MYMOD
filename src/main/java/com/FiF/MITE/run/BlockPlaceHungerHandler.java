//package com.FiF.MITE.run;
//
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.level.GameType;
//import net.minecraftforge.event.level.BlockEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = "mite", bus = Mod.EventBusSubscriber.Bus.FORGE)
//public class BlockPlaceHungerHandler {
//
//    // 每放置一个方块增加的消耗值（exhaustion）
//    private static final float EXHAUSTION_PER_BLOCK = 0.572f;
//
//    @SubscribeEvent
//    public static void onBlockPlaced(BlockEvent.EntityPlaceEvent event) {
//
//        // 只处理玩家
//        if (!(event.getEntity() instanceof Player player)) return;
//
//        // 只在服务器端处理
//        if (player.level().isClientSide()) return;
//
//        // 增加疲劳值，原版会自动减少饱和度和饱食度
//        player.getFoodData().addExhaustion(EXHAUSTION_PER_BLOCK);
//    }
//
//    @SubscribeEvent
//    public static void onBlockBroken(BlockEvent.BreakEvent event) {
//
//        if (!(event.getPlayer() instanceof ServerPlayer player)) return;
//
//        // 只在生存模式
//        if (player.gameMode.getGameModeForPlayer() != GameType.SURVIVAL) return;
//
//        // 增加一次消耗
//        player.getFoodData().addExhaustion(EXHAUSTION_PER_BLOCK);
//    }
//}
