package com.FiF.MITE.ModItem.Anvil;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class APPLEAnvilEvents {

    // 用于显示铁砧合成结果
    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        // 左边金苹果且数量为 1，右边附魔书
        if (left.getItem() == Items.GOLDEN_APPLE
                && left.getCount() == 1
                && right.getItem() == Items.ENCHANTED_BOOK) {

            // 创建输出：金苹果附上书上的附魔
            ItemStack result = left.copy();
            result.setCount(1); // 输出只一个苹果
            EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(right), result);

            // 设置铁砧输出和消耗等级显示
            event.setOutput(result);
            event.setCost(10); // 铁砧本身消耗等级
        } else {
            // 其他情况不允许合成
            event.setOutput(ItemStack.EMPTY);
            event.setCost(0);
        }
    }

    // 玩家取出结果时额外扣经验并消耗金苹果
    @SubscribeEvent
    public static void onAnvilTake(AnvilRepairEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();
        ItemStack output = event.getOutput();

        // 左边金苹果且右边附魔书且输出是金苹果
        if (left.getItem() == Items.GOLDEN_APPLE
                && right.getItem() == Items.ENCHANTED_BOOK
                && output.getItem() == Items.GOLDEN_APPLE) {

            if (event.getEntity() instanceof ServerPlayer serverPlayer) { // ← 1.20.1 Forge 获取玩家
                int extraLevels = 10;
                int newLevel = Math.max(0, serverPlayer.experienceLevel - extraLevels);
                serverPlayer.setExperienceLevels(newLevel);

                // 消耗左边的 1 个金苹果
                left.shrink(1);
            }
        }
    }
}
