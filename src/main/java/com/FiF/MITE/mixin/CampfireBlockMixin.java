package com.FiF.MITE.mixin;

import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.context.BlockPlaceContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CampfireBlock.class)
public class CampfireBlockMixin {

    /**
     * 注入 getStateForPlacement 方法返回前
     * 修改 LIT 为 false（熄灭）
     */
    @Inject(method = "getStateForPlacement", at = @At("RETURN"), cancellable = true)
    private void onGetStateForPlacement(BlockPlaceContext context, CallbackInfoReturnable<BlockState> cir) {
        BlockState original = cir.getReturnValue();
        if (original != null) {
            cir.setReturnValue(original.setValue(CampfireBlock.LIT, false));
        }
    }
}
