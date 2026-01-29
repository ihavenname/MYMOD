package com.FiF.MITE.mixin;

import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(FoodData.class)
public abstract class FoodDataMixin {

    /**
     * @author cj
     * @reason 永远允许吃，不受饱食度限制
     */
    @Overwrite
    public boolean needsFood() {
        return true;
    }
}
