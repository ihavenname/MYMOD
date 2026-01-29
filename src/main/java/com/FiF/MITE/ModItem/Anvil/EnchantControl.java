//package com.FiF.MITE.ModItem.Anvil;
//
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.world.item.ItemStack;
//import net.minecraftforge.event.AnvilUpdateEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//
//public class EnchantControl {
//
//    @SubscribeEvent
//    public static void onAnvilUpdate(AnvilUpdateEvent event) {
//        ItemStack left = event.getLeft();
//        ItemStack right = event.getRight();
//
//        if (left.isEmpty()) return;
//
//        // 判断是否已经附魔过
//        boolean enchantedOnce = false;
//        CompoundTag tag = left.getTag();
//        if (tag != null) {
//            enchantedOnce = tag.getBoolean("MITE:EnchantedOnce");
//        }
//
//        boolean hasEnchantment = !left.getEnchantmentTags().isEmpty();
//
//        // 如果左边装备已经附魔过，阻止铁砧增加附魔
//        if (enchantedOnce || hasEnchantment) {
//            ItemStack output = left.copy();
//
//            // 处理耐久修复
//            if (right != null && !right.isEmpty()) {
//                int repairAmount = right.getMaxDamage() - right.getDamageValue();
//                int newDamage = Math.max(0, left.getDamageValue() - repairAmount);
//                output.setDamageValue(newDamage);
//            }
//
//            // 设置输出，并且消耗为 0（防止附魔/经验消耗）
//            event.setOutput(output);
//            event.setCost(0);
//            event.setMaterialCost(0);
//        }
//    }
//
//    // 附魔台附魔成功后调用，给物品打标记
//    public static void markEnchanted(ItemStack stack) {
//        if (stack.isEmpty()) return;
//        CompoundTag tag = stack.getOrCreateTag();
//        if (!tag.contains("MITE:EnchantedOnce")) {
//            tag.putBoolean("MITE:EnchantedOnce", true);
//        }
//    }
//}
