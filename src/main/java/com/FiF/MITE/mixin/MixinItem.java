package com.FiF.MITE.mixin;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class MixinItem {

    @Inject(method = "getFoodProperties", at = @At("HEAD"), cancellable = true)
    private void modifyFoodProperties(CallbackInfoReturnable<FoodProperties> cir) {
        Item item = (Item) (Object) this;

        if (item == Items.APPLE) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(2) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        // 检查是否为金苹果
        if (item == Items.GOLDEN_APPLE) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(2) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }

        if (item == Items.MELON_SLICE) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(1) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.SWEET_BERRIES) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(1) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.GLOW_BERRIES) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(1) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.CHORUS_FRUIT) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(1) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.CARROT) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(2) // 饱食度设为1
                    .saturationMod(0.25f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.GOLDEN_CARROT) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(2) // 饱食度设为1
                    .saturationMod(0.25f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.POTATO) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(2) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.BAKED_POTATO) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(4) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.BEEF) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(5) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.COOKED_BEEF) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(10) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.PORKCHOP) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(4) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.COOKED_PORKCHOP) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(8) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.MUTTON) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(3) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.COOKED_MUTTON) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(6) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.CHICKEN) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(3) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.COOKED_CHICKEN) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(6) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.RABBIT) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(3) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.COOKED_RABBIT) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(6) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.COD) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(3) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.COOKED_COD) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(6) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.SALMON) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(3) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.COOKED_SALMON) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(6) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.COD) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(3) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.COOKED_COD) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(6) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.BREAD) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(5) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.COOKIE) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(2) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.PUMPKIN_PIE) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(5) // 饱食度设为1
                    .saturationMod(0.5f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.ROTTEN_FLESH) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(2) // 饱食度设为1
                    .saturationMod(0.25f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.SPIDER_EYE) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(1) // 饱食度设为1
                    .saturationMod(0f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.MUSHROOM_STEW) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(4) // 饱食度设为1
                    .saturationMod(0.25f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }
        if (item == Items.BEETROOT_SOUP) {
            // 创建新的食物属性，饱食度和饱和度都设为1
            FoodProperties modifiedFood = new FoodProperties.Builder()
                    .nutrition(4) // 饱食度设为1
                    .saturationMod(0.25f) // 饱和度倍数设为2.0，实际饱和度 = 营养值 * 饱和度倍数 = 1 * 2.0 = 2.0
                    .build();

            cir.setReturnValue(modifiedFood);
        }

    }
}