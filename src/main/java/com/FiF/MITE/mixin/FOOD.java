package com.FiF.MITE.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoodData.class)
class FOOD {

    @Shadow private int foodLevel;
    @Shadow private float saturationLevel;

    @Inject(method = "tick", at = @At("TAIL"))
    private void limitFoodTick(Player player, CallbackInfo ci) {
        if (player.level().isClientSide) return; // ✅ 使用 level() 方法

        int maxFood = (int) player.getMaxHealth();

        if (foodLevel > maxFood) foodLevel = maxFood;
        if (saturationLevel > maxFood) saturationLevel = maxFood;
    }
}

