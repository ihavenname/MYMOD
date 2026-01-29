//package com.FiF.MITE.ModItem;
//
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.item.BucketItem;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.material.Fluid;
//
//public class CustomBucketItem extends BucketItem {
//
//    private final Item emptyBucket; // 放液体后返回的空桶
//
//    public CustomBucketItem(Fluid fluid, Item emptyBucket, Item.Properties properties) {
//        super(fluid, properties);
//        this.emptyBucket = emptyBucket;
//    }
//
//    @Override
//    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
//        // 调用父类 finishUsingItem 保持放液体逻辑
//        super.finishUsingItem(stack, world, user);
//        // 返回自定义空桶
//        return new ItemStack(emptyBucket != null ? emptyBucket : stack.getItem());
//    }
//}
