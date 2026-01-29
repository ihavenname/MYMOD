//package com.FiF.MITE.campfire;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.CampfireBlock;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.event.level.BlockEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = "mite")
//public class CampfirePlaceHandler {
//
//    @SubscribeEvent
//    public static void onCampfirePlace(BlockEvent.EntityPlaceEvent event) {
//        BlockState state = event.getPlacedBlock();
//
//        // 判断是否是营火或灵魂营火
//        if (state.is(Blocks.CAMPFIRE) || state.is(Blocks.SOUL_CAMPFIRE)) {
//            // 获取世界和位置
//            Level world = (Level) event.getLevel();
//            BlockPos pos = event.getPos();
//
//            // 设置熄灭
//            BlockState newState = state.setValue(CampfireBlock.LIT, false);
//            world.setBlock(pos, newState, 3);
//        }
//    }
//}
