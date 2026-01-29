package com.FiF.MITE.run;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "mite", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockPlaceHungerHandler2 {

    // 每放置或破坏一个方块增加的疲劳值
    private static final float EXHAUSTION_PER_BLOCK = 0.572f;

    @SubscribeEvent
    public static void onBlockPlaced(BlockEvent.EntityPlaceEvent event) {
        // 只处理玩家
        if (!(event.getEntity() instanceof Player player)) return;

        // 只在服务器端处理
        if (player.level().isClientSide()) return;

        BlockState state = event.getPlacedBlock();
        if (isInstantBreak(state)) return; // 秒破方块不增加消耗

        // 增加疲劳值
        player.getFoodData().addExhaustion(EXHAUSTION_PER_BLOCK);
    }

    @SubscribeEvent
    public static void onBlockBroken(BlockEvent.BreakEvent event) {
        if (!(event.getPlayer() instanceof ServerPlayer player)) return;

        // 只在生存模式
        if (player.gameMode.getGameModeForPlayer() != GameType.SURVIVAL) return;

        BlockState state = event.getState();
        if (isInstantBreak(state)) return; // 秒破方块不增加消耗

        // 增加一次消耗
        player.getFoodData().addExhaustion(EXHAUSTION_PER_BLOCK);
    }

    // 判断是否为秒破方块
    private static boolean isInstantBreak(BlockState state) {
        Block block = state.getBlock();
        float speed = state.getDestroySpeed(null, null); // level & pos 可传 null
        // destroySpeed <= 0 或特殊瞬间破坏方块（如花、火把）
        return speed <= 0f || block.defaultDestroyTime() == 0f;
    }
}
