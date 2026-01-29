package com.FiF.MITE.ModItem;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties ZERO_HUNGER_ONE_SATURATION =
            new FoodProperties.Builder()
                    .nutrition(1)          // 0 点饥饿
                    .saturationMod(1.0f)   // 1 点饱和度
                    .build();
}
