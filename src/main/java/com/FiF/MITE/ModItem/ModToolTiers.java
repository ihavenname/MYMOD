package com.FiF.MITE.ModItem;

import com.FiF.MITE.MITE;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

/**
 * 这里不注册任何新 Tier，所有工具直接用原版 Tier。
 * 挖矿等级、挖矿范围完全等同原版。
 */
public class ModToolTiers {

    // 火岩系列 - 直接用 WOOD Tier 挖矿等级
    public static final Tier FIRE_ROCK_KNIFE = Tiers.WOOD;
    public static final Tier FIRE_ROCK = Tiers.WOOD;
    public static final Tier FIRE_ROCK_THREE = Tiers.WOOD;

    // 黑玻璃系列 - 直接用 WOOD Tier
    public static final Tier BLACK_GLASS_KINFE = Tiers.WOOD;
    public static final Tier BLACK_GLASS = Tiers.WOOD;
    public static final Tier BLACK_GLASS_THREE = Tiers.WOOD;

    // 木棒强化版 - 直接用 WOOD
    public static final Tier WOOD_TWO = Tiers.WOOD;

    // 铜制工具 - 直接用 STONE Tier（挖矿等级与原版石镐一致）
    public static final Tier COPPER_PICKAXE = Tiers.STONE;
    public static final Tier COPPER_SWORD = Tiers.STONE;
    public static final Tier COPPER_AXE = Tiers.STONE;

    // 自定义铁制工具 - 挖矿等级与原版铁镐一致
    public static final Tier MOD_IRON_SWORD = Tiers.IRON;
    public static final Tier MOD_IRON_SHOVEL = Tiers.IRON;
    public static final Tier MOD_IRON_AXE = Tiers.IRON;
    public static final Tier MOD_IRON_PICKAXE = Tiers.IRON;
    public static final Tier MOD_IRON_HOE = Tiers.IRON;

    // 钢制工具 - 挖矿等级与原版铁镐一致
    public static final Tier STEEL_SWORD = Tiers.IRON;
    public static final Tier STEEL_SHOVEL = Tiers.IRON;
    public static final Tier STEEL_AXE = Tiers.IRON;
    public static final Tier STEEL_PICKAXE = Tiers.IRON;
    public static final Tier STEEL_HOE = Tiers.IRON;

    public static final Tier MOD_IRON_SWORD2 = TierSortingRegistry.registerTier
            ( new ForgeTier( 0, 128, 5f, 0.5f, 14,
                    Tags.Blocks.NEEDS_WOOD_TOOL, () -> Ingredient.of(Items.IRON_INGOT) )
                    , new ResourceLocation(MITE.MOD_ID, "mod_iron_sword_tier"),
                    List.of(Tiers.WOOD),
                    List.of());

}
