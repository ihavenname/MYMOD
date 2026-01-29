package com.FiF.MITE.ModItem;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "mite", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TridentRemovalHandler {

    @SubscribeEvent
    public static void onWorldTick(TickEvent.LevelTickEvent event) {
        if (event.level.isClientSide()) return; // 服务端才处理
        if (event.phase != TickEvent.Phase.END) return; // tick 结束阶段

        // 遍历所有玩家
        for (Player player : event.level.players()) {

            // 清除背包中的三叉戟
            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                ItemStack stack = player.getInventory().getItem(i);
                if (stack.is(Items.TRIDENT)) {
                    player.getInventory().setItem(i, ItemStack.EMPTY);
                }
            }

            // 清除副手的三叉戟
            ItemStack offhand = player.getOffhandItem();
            if (offhand.is(Items.TRIDENT)) {
                player.setItemInHand(player.getUsedItemHand(), ItemStack.EMPTY);
            }
        }
    }
}
