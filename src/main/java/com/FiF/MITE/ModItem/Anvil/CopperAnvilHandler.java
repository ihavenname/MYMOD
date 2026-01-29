package com.FiF.MITE.ModItem.Anvil;

import com.FiF.MITE.ModItem.ModArmorMaterials;
import com.FiF.MITE.ModItem.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CopperAnvilHandler {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        // ===== 判断：是否为“铜材质盔甲” =====
        if (!(left.getItem() instanceof ArmorItem armor)) return;
        if (armor.getMaterial() != ModArmorMaterials.COPPER) return;

        // Mod 的铜粒
        if (right.isEmpty() || right.getItem() != ModItems.TinyCopper.get()) return;

        // 没有损坏就不处理
        if (!left.isDamaged()) return;

        int nuggetCount = right.getCount(); // 右侧铜粒数量

        // 当前损坏值
        int damage = left.getDamageValue();

        // 实际可修复量（不能修过头）
        int repairAmount = Math.min(nuggetCount, damage);

        // 如果没有可修复的就直接 return
        if (repairAmount <= 0) return;

        ItemStack output = left.copy();

        // 按数量修复
        output.setDamageValue(damage - repairAmount);

        event.setOutput(output);

        // 消耗对应数量的铜粒
        event.setMaterialCost(repairAmount);

        // 不消耗经验
        event.setCost(1);
    }
}



