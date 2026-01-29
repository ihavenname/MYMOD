package com.FiF.MITE.ModItem.Anvil;

import com.FiF.MITE.ModItem.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SteelCutAnvilHandler {

    private static final int REPAIR_PER_NUGGET = 26;

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        // 只修这个物品
        if (left.getItem() != ModItems.STEEL_CUT.get()) return;

        // 使用原版铁粒
        if (right.isEmpty() || right.getItem() != ModItems.TINY_STEEL.get()) return;

        // 没损坏不处理
        if (!left.isDamaged()) return;

        int nuggetCount = right.getCount();
        int damage = left.getDamageValue();

        // 总可修复量
        int maxRepair = nuggetCount * REPAIR_PER_NUGGET;

        // 实际修复量（不能超过损坏）
        int actualRepair = Math.min(maxRepair, damage);
        if (actualRepair <= 0) return;

        // 实际消耗的铁粒数量（向上取整）
        int usedNuggets = (int) Math.ceil(
                actualRepair / (double) REPAIR_PER_NUGGET
        );

        ItemStack output = left.copy();
        output.setDamageValue(damage - actualRepair);

        event.setOutput(output);

        // 消耗铁粒
        event.setMaterialCost(usedNuggets);

        // 不消耗经验
        event.setCost(1);
    }
}
