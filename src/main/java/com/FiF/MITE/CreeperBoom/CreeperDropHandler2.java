package com.FiF.MITE.CreeperBoom;

import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Iterator;
import java.util.List;

@Mod.EventBusSubscriber(modid = "mite")
public class CreeperDropHandler2 {

    @SubscribeEvent
    public static void onCreeperExplode(ExplosionEvent.Detonate event) {
        Level level = event.getLevel();
        List<BlockPos> affectedBlocks = event.getAffectedBlocks();
        if (!(event.getExplosion().getIndirectSourceEntity() instanceof Creeper)) return;

        // 使用迭代器避免 ConcurrentModificationException
        Iterator<BlockPos> iterator = affectedBlocks.iterator();
        while (iterator.hasNext()) {
            BlockPos pos = iterator.next();
            BlockState state = level.getBlockState(pos);

            if (state.is(Blocks.DIRT) || state.is(Blocks.GRASS_BLOCK) ||
                    state.is(Blocks.SAND) || state.is(Blocks.GRAVEL)) {
                // 泥土/沙砾保留原版掉落
                continue;
            } else {
                // 非泥土/沙砾方块：破坏但不掉落
                level.removeBlock(pos, false);
                // 从爆炸列表中移除，防止默认爆炸掉落
                iterator.remove();
            }
        }

        // 注意：不要调用 explosion.clearToBlow()，否则泥土/沙砾也不会掉落
    }
}
