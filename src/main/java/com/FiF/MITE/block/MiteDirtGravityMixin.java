//package com.FiF.MITE.block;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.util.RandomSource;
//import net.minecraft.world.entity.item.FallingBlockEntity;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.LevelAccessor;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.FallingBlock;
//import net.minecraft.world.level.block.state.BlockState;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(FallingBlock.class)
//public abstract class MiteDirtGravityMixin {
//
//    @Inject(
//            method = "tick",
//            at = @At("HEAD"),
//            cancellable = true
//    )
//    private void mite$makeDirtFall(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci) {
//
//        // 如果是原版 FallingBlock（沙子等），让原逻辑跑
//        if (state.getBlock() instanceof FallingBlock) return;
//
//        // 只对 Dirt 和 Soul Sand 生效
//        if (state.getBlock() != Blocks.DIRT && state.getBlock() != Blocks.SOUL_SAND) return;
//
//        if (FallingBlock.isFree(level.getBlockState(pos.below())) && pos.getY() >= level.getMinBuildHeight()) {
//            FallingBlockEntity.fall(level, pos, state);
//            ci.cancel(); // 阻止 FallingBlock 后续逻辑
//        }
//    }
//}
//
//
//
