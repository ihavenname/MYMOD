//package com.FiF.MITE.BreakBlcok;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.event.entity.player.PlayerEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//import java.util.Optional;
//
//@Mod.EventBusSubscriber(modid = "mite", bus = Mod.EventBusSubscriber.Bus.FORGE)
//public class Blcokkiller {
//
//    @SubscribeEvent
//    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
//        Player player = event.getEntity();
//        Level level = player.level();
//        BlockState state = event.getState();
//
//        Optional<BlockPos> posOpt = event.getPosition();
//        if (posOpt.isEmpty()) return;
//
//        BlockPos pos = posOpt.get();
//        float hardness = state.getDestroySpeed(level, pos);
//
//        if (hardness < 0) return;
//
//        float originalSpeed = event.getOriginalSpeed();
//        if (originalSpeed <= 0) return;
//
//        float playerSpeed = 1.0f;
//
//        // ===== 硬度规则层 =====
//        float effectiveHardness = hardness;
//
//        // ★ 仅草类：按 0.02 硬度处理
////        if (isGrassLike(state)) {
////            effectiveHardness = 0.02f;
////        }
//        // 特例：0.6 → 0.5
//        if (Math.abs(hardness - 0.6f) < 0.0001f) {
//            effectiveHardness = 0.5f;
//        }
//
//        float baseHardness = hardness;
//        if (hardness == 0.0f) {
//            baseHardness = 1.0f;
//        }
//
//        float multiplier =
//                (30.0f * baseHardness) / (512.0f * effectiveHardness);
//
//        float newSpeed = originalSpeed * multiplier;
//        event.setNewSpeed(newSpeed);
//    }
//
//    private static boolean isGrassLike(BlockState state) {
//        return state.is(net.minecraft.world.level.block.Blocks.GRASS)
//                || state.is(net.minecraft.world.level.block.Blocks.TALL_GRASS)
//                || state.is(net.minecraft.world.level.block.Blocks.FERN)
//                || state.is(net.minecraft.world.level.block.Blocks.LARGE_FERN);
//    }
//}
//
//
//
//
//
//
