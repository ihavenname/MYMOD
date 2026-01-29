package com.FiF.MITE.run;

import com.FiF.MITE.MITE;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@Mod.EventBusSubscriber(modid = MITE.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SimpleTorchLandingHandler {

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        // 遍历所有世界
        event.getServer().getAllLevels().forEach(SimpleTorchLandingHandler::processWorld);
    }

    private static void processWorld(Level level) {
        if (level.isClientSide()) return;

        // 查找下落方块实体
        AABB area = new AABB(level.getSharedSpawnPos()).inflate(100);
        level.getEntitiesOfClass(FallingBlockEntity.class, area).forEach(entity -> {
            if (!entity.isRemoved() && !entity.onGround()) {
                handleFallingEntity(entity, level);
            }
        });
    }

    private static void handleFallingEntity(FallingBlockEntity entity, Level level) {
        BlockPos entityPos = entity.blockPosition();
        BlockPos belowPos = entityPos.below();
        BlockState belowState = level.getBlockState(belowPos);

        // 检查下方是否是火把
        if (isTorch(belowState.getBlock())) {
            // 检查碰撞
            double distanceToTorch = entity.getY() - belowPos.getY();
            if (distanceToTorch < 1.2) { // 接近火把
                // 直接放置方块
                BlockState fallingState = entity.getBlockState();
                BlockPos placePos = belowPos.above(); // 放在火把的位置上

                if (fallingState.canSurvive(level, placePos)) {
                    // 移除火把，放置方块
                    level.removeBlock(belowPos, false); // 移除火把但不掉落物品
                    level.setBlock(placePos, fallingState, 3);
                    entity.discard();
                }
            }
        }
    }

    private static boolean isTorch(Block block) {
        return block == Blocks.TORCH ||
                block == Blocks.WALL_TORCH ||
                block == Blocks.REDSTONE_TORCH ||
                block == Blocks.REDSTONE_WALL_TORCH ||
                block == Blocks.SOUL_TORCH ||
                block == Blocks.SOUL_WALL_TORCH;
    }
}