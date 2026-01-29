package com.FiF.MITE.mixin;

import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {

    /**
     * 拦截 bobHurt 方法里对 getHurtDir() 的调用，永远返回 0
     */
    @Redirect(
            method = "bobHurt(Lcom/mojang/blaze3d/vertex/PoseStack;F)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;getHurtDir()F"
            )
    )
    private float redirectGetHurtDir(LivingEntity instance) {
        return 0.0f; // 永远返回 0
    }
}
