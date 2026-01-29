//package com.FiF.MITE.block;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.state.BlockState;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(Level.class)
//public abstract class DirtScheduleMixin {
//
//    @Inject(
//            method = "setBlock",
//            at = @At("TAIL")
//    )
//    private void mite$scheduleDirt(BlockPos pos, BlockState state, int flags, int recursion, CallbackInfoReturnable<Boolean> cir) {
//        if (state.is(Blocks.DIRT) || state.is(Blocks.SOUL_SAND)) {
//            ((Level)(Object)this).scheduleTick(pos, Blocks.SAND, 2);
//        }
//    }
//}
//
