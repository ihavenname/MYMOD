package com.FiF.MITE.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.portal.PortalShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PortalShape.class)
public abstract class PortalShapeMixin {

    @Shadow @Final
    private LevelAccessor level;

    @Shadow
    private BlockPos bottomLeft;

    @Shadow
    private int width;

    // 🔑 这是关键：PortalShape 已经帮你算好的宽度方向
    @Shadow @Final
    private Direction rightDir;

    @Inject(
            method = "createPortalBlocks",
            at = @At("HEAD"),
            cancellable = true
    )
    private void mite$requireBedrockUnderFrame(CallbackInfo ci) {

        // 黑曜石底框下面一格
        BlockPos frameBottom = bottomLeft.below(2);

        for (int i = 0; i < width; i++) {
            BlockPos checkPos = frameBottom.relative(rightDir, i);

            if (level.getBlockState(checkPos).is(Blocks.BEDROCK)) {
                return; // ✅ 任意底部位置有基岩 → 允许激活
            }
        }

        // ❌ 底部整排都没有基岩
        ci.cancel();
    }
}


//@Mixin(PortalShape.class)
//public abstract class PortalShapeMixin {
//
//    @Shadow @Final
//    private LevelAccessor level;
//
//    @Shadow
//    private BlockPos bottomLeft;
//
//    @Shadow
//    private int width;
//
//    @Shadow
//    private Direction.Axis axis;
//
//    @Inject(
//            method = "createPortalBlocks",
//            at = @At("HEAD"),
//            cancellable = true
//    )
//    private void mite$requireBedrockUnderPortal(CallbackInfo ci) {
//
//        Direction scanDir = (axis == Direction.Axis.X)
//                ? Direction.EAST
//                : Direction.SOUTH;
//
//        for (int i = 0; i < width; i++) {
//            BlockPos checkPos = bottomLeft
//                    .relative(scanDir, i)
//                    .below();
//
//            if (level.getBlockState(checkPos).is(Blocks.BEDROCK)) {
//                return; // 有基岩 → 允许生成
//            }
//        }
//
//        ci.cancel(); // ❌ 没有任何基岩 → 阻止生成
//    }
//}
