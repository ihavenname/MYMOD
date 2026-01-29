//package com.FiF.MITE.ModItem.Anvil;
//
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.entity.item.ItemEntity;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber
//public class IronSwordInWaterHandler {
//
//    @SubscribeEvent
//    public static void onEntityTick(TickEvent.EntityTickEvent event) {
//        Entity entity = event.entity;
//
//        // 只在服务端处理
//        if (entity.level().isClientSide) return;
//
//        // 只处理掉落物
//        if (!(entity instanceof ItemEntity itemEntity)) return;
//
//        ItemStack stack = itemEntity.getItem();
//
//        // 只处理铁剑
//        if (stack.getItem() != Items.IRON_SWORD) return;
//
//        // 必须在水中
//        if (!itemEntity.isInWater()) return;
//
//        // ===== 转换 =====
//
//        // 生成木剑
//        ItemStack woodenSword = new ItemStack(Items.WOODEN_SWORD);
//
//        ItemEntity newEntity = new ItemEntity(
//                entity.level(),
//                entity.getX(),
//                entity.getY(),
//                entity.getZ(),
//                woodenSword
//        );
//
//        // 防止立刻被再次处理
//        newEntity.setPickUpDelay(10);
//
//        // 删除原铁剑
//        entity.discard();
//
//        // 生成新实体
//        entity.level().addFreshEntity(newEntity);
//    }
//}
