package com.FiF.MITE.run;

import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = "mite", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VillagerTradeHandler {

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {

        Int2ObjectMap<List<ItemListing>> trades = event.getTrades();

        // 清空所有原版交易
        for (List<ItemListing> list : trades.values()) {
            list.clear();
        }

        // 只保留一个交易：白色羊毛换绿宝石
        trades.get(1).add((trader, rand) ->
                new MerchantOffer(
                        new ItemStack(Items.WHITE_WOOL, 9), // 玩家给的物品
                        new ItemStack(Items.EMERALD_BLOCK, 1),    // 玩家得到的物品
                        64,    // 最大交易次数
                        10,    // 村民获得经验
                        0.0f   // 价格上涨系数
                )
        );
        trades.get(2).add((trader, rand) ->
                new MerchantOffer(
                        new ItemStack(Items.DIRT, 9), // 玩家给的物品
                        new ItemStack(Items.DIAMOND_BLOCK, 1),    // 玩家得到的物品
                        64,    // 最大交易次数
                        10,    // 村民获得经验
                        0.0f   // 价格上涨系数
                )
        );
    }
}
