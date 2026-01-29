package com.FiF.MITE.ModItem;

import com.FiF.MITE.MITE;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MITE.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MITE_TAB =
            CREATIVE_MODE_TABS.register("mite_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.TinyCopper.get()))
                    .title(Component.translatable("itemGroup.mite_tab"))
                    .displayItems((parameters, output) -> {

                        // ====== 基础材料 ======
                        output.accept(ModItems.TinyCopper.get());
                        output.accept(ModItems.TinyFireRock.get());
                        output.accept(ModItems.TinyBlackGlass.get());
                        output.accept(ModItems.AnimalSkinString.get());

                        // ====== 刀 / 匕首 ======
                        output.accept(ModItems.FIRE_ROCK_KNIFE.get());
                        output.accept(ModItems.BLACK_GLASS_KNIFE.get());
                        output.accept(ModItems.STRONG_STICK.get());

                        // ====== 斧头 ======
                        output.accept(ModItems.TINY_FIRE_ROCK_AXE.get());
                        output.accept(ModItems.TINY_BLACK_GLASS_AXE.get());
                        output.accept(ModItems.FIRE_ROCK_AXE.get());
                        output.accept(ModItems.BLACK_GLASS_AXE.get());
                        output.accept(ModItems.COPPER_AXE.get());
                        output.accept(ModItems.MOD_IRON_AXE.get());
                        output.accept(ModItems.STEEL_AXE.get());


                        // ====== 镐子 ======
                        output.accept(ModItems.COPPER_PICKAXE.get());
                        output.accept(ModItems.MOD_IRON_PICKAXE.get());
                        output.accept(ModItems.STEEL_PICKAXE.get());

                        // ====== 铲子 ======
                        output.accept(ModItems.COPPER_SHOVEL.get());
                        output.accept(ModItems.MOD_IRON_SHOVEL.get());
                        output.accept(ModItems.STEEL_SHOVEL.get());

                        // ====== 剑 ======
                        output.accept(ModItems.COPPER_SWORD.get());
                        output.accept(ModItems.MOD_IRON_SWORD.get());
                        output.accept(ModItems.STEEL_SWORD.get());

                        // ====== 锄 ======
                        output.accept(ModItems.COPPER_HOE.get());
                        output.accept(ModItems.MOD_IRON_HOE.get());
                        output.accept(ModItems.STEEL_HOE.get());

                        // ====== 剪刀 ======
                        output.accept(ModItems.COPPER_CUT.get());
                        output.accept(ModItems.MOD_IRON_CUT.get());
                        output.accept(ModItems.STEEL_CUT.get());

                        // ====== 护甲：铜 ======
                        output.accept(ModItems.COPPER_HELMET.get());
                        output.accept(ModItems.COPPER_CHESTPLATE.get());
                        output.accept(ModItems.COPPER_LEGGINGS.get());
                        output.accept(ModItems.COPPER_BOOTS.get());

                        // ====== 护甲：铁 ======
                        output.accept(ModItems.MOD_IRON_HELMET.get());
                        output.accept(ModItems.MOD_IRON_CHESTPLATE.get());
                        output.accept(ModItems.MOD_IRON_LEGGINGS.get());
                        output.accept(ModItems.MOD_IRON_BOOTS.get());

                        // ====== 护甲：钢 ======
                        output.accept(ModItems.STEEL_HELMET.get());
                        output.accept(ModItems.STEEL_CHESTPLATE.get());
                        output.accept(ModItems.STEEL_LEGGINGS.get());
                        output.accept(ModItems.STEEL_BOOTS.get());

                        // ====== 金属与杂项 ======
                        output.accept(ModItems.STEEL_INGOT.get());
                        output.accept(ModItems.TINY_STEEL.get());
                        output.accept(ModItems.FIRE_STEEL_INGOT.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}