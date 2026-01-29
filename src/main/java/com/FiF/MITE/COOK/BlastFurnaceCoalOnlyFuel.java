package com.FiF.MITE.COOK;

import com.FiF.MITE.MITE;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MITE.MOD_ID)
public class BlastFurnaceCoalOnlyFuel {

    @SubscribeEvent
    public static void onFuelBurnTime(FurnaceFuelBurnTimeEvent event) {

        // 只限制高炉（BLASTING）
        if (event.getRecipeType() != RecipeType.BLASTING) {
            return;
        }

        ItemStack fuel = event.getItemStack();

        // 不是煤炭，禁止燃烧
        if (fuel.getItem() != Items.COAL) {
            event.setBurnTime(0);
        }
    }
}
