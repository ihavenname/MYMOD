//package com.FiF.MITE.CreeperBoom;
//
//import net.minecraft.world.entity.monster.Creeper;
//import net.minecraft.world.level.Explosion;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.core.BlockPos;
//import net.minecraftforge.event.level.ExplosionEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//import java.util.Iterator;
//import java.util.List;
//
//@Mod.EventBusSubscriber(modid = "mymod")
//public class CreeperDropHandler {
//
//    @SubscribeEvent
//    public static void onCreeperExplode(ExplosionEvent.Detonate event) {
//        Explosion explosion = event.getExplosion();
//
//        // 判断爆炸的源头是否是苦力怕
//        if (explosion.getIndirectSourceEntity() instanceof Creeper) {
//
//            // 获取爆炸影响的方块列表
//            List<BlockPos> affectedBlocks = event.getAffectedBlocks();
//
//            // 清空掉落物，保留方块破坏
//            for (BlockPos pos : affectedBlocks) {
//                BlockState state = event.getLevel().getBlockState(pos);
//
//                // 保留方块破坏，但不掉落物品
//                // 方法：直接把方块置为空方块，避免原版爆炸生成掉落
//                event.getLevel().removeBlock(pos, false);
//            }
//
//            // 阻止爆炸生成默认掉落（保险做法）
//            explosion.clearToBlow();
//        }
//    }
//}
