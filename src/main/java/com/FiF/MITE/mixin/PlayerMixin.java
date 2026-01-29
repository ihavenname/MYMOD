package com.FiF.MITE.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * 修复和平模式下饱食度突破上限的问题
 */
@Mixin(Player.class)
public abstract class PlayerMixin {

    /**
     * @author cj
     * @reason
     *  和平模式下 aiStep() 会在 needsFood() 为 true 时
     *  每 10 tick 强制 foodLevel + 1
     *  这里拦截 needsFood，使和平模式不再自动加饱食度
     */
    @Redirect(
            method = "aiStep",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/food/FoodData;needsFood()Z"
            )
    )
    private boolean mite$disablePeacefulAutoFeed(FoodData foodData) {
        // 永远返回 false：禁止和平模式自动补饱食度
        return false;
    }
}
