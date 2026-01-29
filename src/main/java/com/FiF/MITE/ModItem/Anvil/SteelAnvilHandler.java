package com.FiF.MITE.ModItem.Anvil;

import com.FiF.MITE.ModItem.ModArmorMaterials;
import com.FiF.MITE.ModItem.ModItems;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SteelAnvilHandler {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        if (left.isEmpty() || right.isEmpty()) return;

        // ===== 铜材质盔甲 =====
        if (!(left.getItem() instanceof ArmorItem armor)) return;
        if (armor.getMaterial() != ModArmorMaterials.STEEL) return;

        // ===== 铜粒 =====
        if (right.getItem() != ModItems.TINY_STEEL.get()) return;

        // 没损坏就不修
        if (!left.isDamaged()) return;

        int nuggetCount = right.getCount();
        int damage = left.getDamageValue();

// 4 个铁粒一组
        int groups = nuggetCount / 3;
        if (groups <= 0) return;

// 每组修 7 点耐久
        int repairPoints = groups * 8;

// 不能修过头
        repairPoints = Math.min(repairPoints, damage);

        ItemStack output = left.copy();
        output.setDamageValue(damage - repairPoints);

        event.setOutput(output);

// 实际消耗：每组 4 个铁粒
        event.setMaterialCost(groups * 3);

// 不吃经验
        event.setCost(1);
    }
}
