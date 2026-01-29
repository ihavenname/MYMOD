package com.FiF.MITE.ModItem;

import com.FiF.MITE.MITE;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MITE.MOD_ID);

    // 小物品
    public static final RegistryObject<Item> TinyCopper =
            ITEMS.register("tiny_copper", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TinyFireRock =
            ITEMS.register("tiny_fire_rock", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TinyBlackGlass =
            ITEMS.register("tiny_black_glass", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AnimalSkinString =
            ITEMS.register("animal_skin_string", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Nothing =
            ITEMS.register("nothing", () -> new Item(new Item.Properties()));

    // 火岩刀
    public static final RegistryObject<Item> FIRE_ROCK_KNIFE = ITEMS.register("fire_rock_knife",
            () -> new KnifeItem(ModToolTiers.FIRE_ROCK_KNIFE, 1, -1, new Item.Properties().durability(40)));

    public static final RegistryObject<Item> BLACK_GLASS_KNIFE = ITEMS.register("black_glass_knife",
            () -> new KnifeItem(ModToolTiers.BLACK_GLASS_KINFE, 1, -1, new Item.Properties().durability(40)));

    public static final RegistryObject<Item> STRONG_STICK = ITEMS.register("strong_stick",
            () -> new KnifeItem(ModToolTiers.WOOD_TWO, 1, -2.4F, new Item.Properties().durability(16)));

    // 火岩斧
    public static final RegistryObject<Item> TINY_FIRE_ROCK_AXE = ITEMS.register("tiny_fire_rock_axe",
            () -> new AxeItem(ModToolTiers.FIRE_ROCK, 1, -1, new Item.Properties().durability(3)));
    public static final RegistryObject<Item> TINY_BLACK_GLASS_AXE = ITEMS.register("tiny_black_glass_axe",
            () -> new AxeItem(ModToolTiers.BLACK_GLASS, 1, -1, new Item.Properties().durability(3)));
    public static final RegistryObject<Item> FIRE_ROCK_AXE = ITEMS.register("fire_rock_axe",
            () -> new AxeItem(ModToolTiers.FIRE_ROCK_THREE, 2, -3, new Item.Properties().durability(12)));
    public static final RegistryObject<Item> BLACK_GLASS_AXE = ITEMS.register("black_glass_axe",
            () -> new AxeItem(ModToolTiers.BLACK_GLASS_THREE, 2, -3, new Item.Properties().durability(12)));

    // 铜工具
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COPPER_PICKAXE, 1, -2.8F, new Item.Properties().durability(20)));
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(ModToolTiers.COPPER_SWORD, 3, -2.4F, new Item.Properties().durability(64)));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(ModToolTiers.COPPER_SWORD, 1.5F, -3F, new Item.Properties().durability(64)));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(ModToolTiers.COPPER_SWORD, -1, -2F, new Item.Properties().durability(64)));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(ModToolTiers.COPPER_AXE, 2, -2.8F, new Item.Properties().durability(40)));
    public static final RegistryObject<Item> COPPER_CUT = ITEMS.register("copper_cut",
            () -> new ModShears(new Item.Properties().stacksTo(1).durability(160)));

    // 铁工具
    public static final RegistryObject<Item> MOD_IRON_SWORD = ITEMS.register("mod_iron_sword",
            () -> new SwordItem(ModToolTiers.MOD_IRON_SWORD2, 4, -2.4F, new Item.Properties().durability(128)));
    public static final RegistryObject<Item> MOD_IRON_SHOVEL = ITEMS.register("mod_iron_shovel",
            () -> new ShovelItem(ModToolTiers.MOD_IRON_SHOVEL, 1, -3F, new Item.Properties().durability(160)));
    public static final RegistryObject<Item> MOD_IRON_AXE = ITEMS.register("mod_iron_axe",
            () -> new AxeItem(ModToolTiers.MOD_IRON_AXE, 1, -2.8F, new Item.Properties().durability(80)));
    public static final RegistryObject<Item> MOD_IRON_PICKAXE = ITEMS.register("mod_iron_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COPPER_PICKAXE, 1, -2.8F, new Item.Properties().durability(40)));
    public static final RegistryObject<Item> MOD_IRON_HOE = ITEMS.register("mod_iron_hoe",
            () -> new HoeItem(ModToolTiers.MOD_IRON_HOE, -2, -2F, new Item.Properties().durability(128)));
    public static final RegistryObject<Item> MOD_IRON_CUT = ITEMS.register("mod_iron_cut",
            () -> new ModShears(new Item.Properties().stacksTo(1).durability(320)));

    // 钢工具
    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(ModToolTiers.STEEL_SWORD, 3, -2.4F, new Item.Properties().durability(192)));
    public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(ModToolTiers.STEEL_SHOVEL, 1.5F, -3F, new Item.Properties().durability(240)));
    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(ModToolTiers.STEEL_AXE, 1, -2.8F, new Item.Properties().durability(120)));
    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STEEL_PICKAXE, 1, -2.8F, new Item.Properties().durability(60)));
    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(ModToolTiers.STEEL_HOE, -2, -2F, new Item.Properties().durability(192)));
    public static final RegistryObject<Item> STEEL_CUT = ITEMS.register("steel_cut",
            () -> new ModShears(new Item.Properties().stacksTo(1).durability(480)));

    // 金属材料
    public static final RegistryObject<Item> STEEL_INGOT =
            ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TINY_STEEL =
            ITEMS.register("tiny_steel", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_STEEL_INGOT =
            ITEMS.register("fire_steel_ingot", () -> new Item(new Item.Properties()));

    // 铜盔甲
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    // 自定义铁盔甲
    public static final RegistryObject<Item> MOD_IRON_HELMET = ITEMS.register("mod_iron_helmet",
            () -> new ArmorItem(ModArmorMaterials.MOD_IRON, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> MOD_IRON_CHESTPLATE = ITEMS.register("mod_iron_chestplate",
            () -> new ArmorItem(ModArmorMaterials.MOD_IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> MOD_IRON_LEGGINGS = ITEMS.register("mod_iron_leggings",
            () -> new ArmorItem(ModArmorMaterials.MOD_IRON, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> MOD_IRON_BOOTS = ITEMS.register("mod_iron_boots",
            () -> new ArmorItem(ModArmorMaterials.MOD_IRON, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    // 钢盔甲
    public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
