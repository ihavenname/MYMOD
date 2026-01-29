//package com.FiF.MITE.GrassBreak;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.level.block.TallGrassBlock;
//import net.minecraft.world.level.block.state.BlockState;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//public class GrassBreakManager {
//
//    private static final Map<UUID, GrassBreakData> DATA = new HashMap<>();
//
//    /** 开始 / 继续挖草 */
//    public static void tick(Player player, BlockPos pos) {
//        if (!(player.level() instanceof ServerLevel level)) return;
//
//        BlockState state = level.getBlockState(pos);
//        if (!(state.getBlock() instanceof TallGrassBlock)) {
//            reset(player);
//            return;
//        }
//
//        GrassBreakData data = DATA.get(player.getUUID());
//
//        // 新目标 or 第一次
//        if (data == null || !data.pos.equals(pos)) {
//            data = new GrassBreakData(
//                    pos,
//                    player.getUUID(),
//                    40 // ★ 挖草时间（tick）= 2 秒
//            );
//            DATA.put(player.getUUID(), data);
//        }
//
//        data.progress++;
//
//        // 同步破坏动画（0-9）
//        int stage = (int) ((float) data.progress / data.maxProgress * 9);
//        level.destroyBlockProgress(player.getId(), pos, stage);
//
//        // 完成
//        if (data.progress >= data.maxProgress) {
//            level.destroyBlock(pos, true, player);
//            reset(player);
//        }
//    }
//
//    /** 中断挖掘 */
//    public static void reset(Player player) {
//        if (!(player.level() instanceof ServerLevel level)) return;
//
//        GrassBreakData data = DATA.remove(player.getUUID());
//        if (data != null) {
//            level.destroyBlockProgress(player.getId(), data.pos, -1);
//        }
//    }
//}
