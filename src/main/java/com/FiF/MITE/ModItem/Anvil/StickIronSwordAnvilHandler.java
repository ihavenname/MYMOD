package com.FiF.MITE.ModItem.Anvil;

import com.FiF.MITE.ModItem.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class StickIronSwordAnvilHandler {

    /**
     * ① 判断 + 显示输出
     */
    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        // 左边：铜锭
        if (left.getItem() != ModItems.FIRE_STEEL_INGOT.get()) return;
        if (left.getCount() <= 0) return;

        // 右边：水桶（必须正好是水桶）
        if (right.getItem() != Items.WATER_BUCKET) return;

        // 输出铁锭，数量 = 铜锭数量
        ItemStack output = new ItemStack(ModItems.STEEL_INGOT.get(), left.getCount());
        event.setOutput(output);

        // 右边只消耗 1 个（水桶）
        event.setMaterialCost(1);

        // 经验消耗（你可以自己调）
        event.setCost(1);
    }


    /**
     * ② 玩家拿走结果 → 给桶
     */
    @SubscribeEvent
    public static void onAnvilRepair(AnvilRepairEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();
        ItemStack output = event.getOutput();
        Player player = event.getEntity(); // ✅ 1.20.1 正确写法

        // 左边：铜锭
        if (left.getItem() != ModItems.FIRE_STEEL_INGOT.get()) return;
        if (left.getCount() <= 0) return;

        // 右边：水桶（必须正好是水桶）
        if (right.getItem() != Items.WATER_BUCKET) return;

        // 给玩家一个桶
        ItemStack bucket = new ItemStack(Items.BUCKET);

        if (!player.getInventory().add(bucket)) {
            player.drop(bucket, false);
        }
    }

}
