//package com.FiF.MITE.run;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.TallGrassBlock;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.entity.player.Player;
//import net.minecraftforge.event.level.BlockEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = "mite", bus = Mod.EventBusSubscriber.Bus.FORGE)
//public class DropSeed {
//
//    private static final float EXPECTED_SEEDS_PER_GRASS = 0.012f;
//    private static final String NBT_KEY = "SeedDropAccumulator";
//
//    @SubscribeEvent
//    public static void onGrassBroken(BlockEvent.BreakEvent event) {
//        Player player = event.getPlayer();
//        if (player == null) return;
//
//        BlockState state = event.getState();
//        if (!(state.getBlock() instanceof TallGrassBlock)) return;
//
//        Level world = (Level) event.getLevel();
//        BlockPos pos = event.getPos();
//
//        // 1️⃣ 设置方块为空 → 原版掉落不会再生成
//        world.setBlock(pos, state.getBlock().defaultBlockState(), 3);
//
//        // 2️⃣ 处理累积掉落
//        float acc = player.getPersistentData().getFloat(NBT_KEY);
//        acc += EXPECTED_SEEDS_PER_GRASS;
//
//        int seedsToDrop = (int) acc;
//        if (seedsToDrop > 0) {
//            for (int i = 0; i < seedsToDrop; i++) {
//                // 掉落在草丛位置
//                state.getBlock().popResource(world, pos, new ItemStack(Items.WHEAT_SEEDS));
//            }
//            acc -= seedsToDrop;
//        }
//
//        player.getPersistentData().putFloat(NBT_KEY, acc);
//    }
//}
