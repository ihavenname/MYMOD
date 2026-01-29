package com.FiF.MITE.reach;

import com.FiF.MITE.ModItem.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.UUID;

public class PlayerReachHandler {

    // 两个固定 UUID，保证不会叠加爆炸
    private static final UUID BLOCK_UUID  = UUID.fromString("11111111-aaaa-bbbb-cccc-111111111111");
    private static final UUID ENTITY_UUID = UUID.fromString("22222222-aaaa-bbbb-cccc-222222222222");

    // ===== 基础距离 =====
    private static final double BASE_BLOCK = 2.75;
    private static final double BASE_ENTITY = 1.5;

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent e) {
        Player p = e.getEntity();
        if (p.getAttribute(ForgeMod.BLOCK_REACH.get()) != null) {
            p.getAttribute(ForgeMod.BLOCK_REACH.get()).setBaseValue(BASE_BLOCK);
        }
        if (p.getAttribute(ForgeMod.ENTITY_REACH.get()) != null) {
            p.getAttribute(ForgeMod.ENTITY_REACH.get()).setBaseValue(BASE_ENTITY);
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (e.phase != TickEvent.Phase.END) return;

        Player p = e.player;
        Item item = p.getMainHandItem().getItem();

        // ===== MITE tiny 斧 & 普通斧分组 =====
        boolean isTinyAxe =
                item == com.FiF.MITE.ModItem.ModItems.TINY_FIRE_ROCK_AXE.get() ||
                        item == com.FiF.MITE.ModItem.ModItems.TINY_BLACK_GLASS_AXE.get() ||
                        item == ModItems.COPPER_CUT.get() ||
                        item == ModItems.STEEL_CUT.get()||
                        item == ModItems.MOD_IRON_CUT.get()
                ;

        boolean isModAxe =
                item == com.FiF.MITE.ModItem.ModItems.FIRE_ROCK_AXE.get() ||
                        item == com.FiF.MITE.ModItem.ModItems.BLACK_GLASS_AXE.get() ||
                        item == ModItems.COPPER_AXE.get() ||
                        item == ModItems.COPPER_SHOVEL.get() ||
                        item == ModItems.COPPER_HOE.get()||
                        item == ModItems.COPPER_PICKAXE.get()||
                        item == ModItems.COPPER_SWORD.get()||
                        item == ModItems.STRONG_STICK.get()||
                        item == ModItems.STEEL_AXE.get() ||
                        item == ModItems.STEEL_SHOVEL.get() ||
                        item == ModItems.STEEL_HOE.get()||
                        item == ModItems.STEEL_PICKAXE.get()||
                        item == ModItems.STEEL_SWORD.get()||
                        item == ModItems.MOD_IRON_AXE.get() ||
                        item == ModItems.MOD_IRON_SHOVEL.get() ||
                        item == ModItems.MOD_IRON_HOE.get()||
                        item == ModItems.MOD_IRON_PICKAXE.get()||
                        item == ModItems.MOD_IRON_SWORD.get()
                ;

        double blockBonus = 0;
        double entityBonus = 0;

        // ===== 1. 所有原版工具（写死版） =====
        if (
                item == Items.WOODEN_SWORD   || item == Items.STONE_SWORD   || item == Items.IRON_SWORD   || item == Items.GOLDEN_SWORD   || item == Items.DIAMOND_SWORD   || item == Items.NETHERITE_SWORD ||
                        item == Items.WOODEN_PICKAXE || item == Items.STONE_PICKAXE || item == Items.IRON_PICKAXE || item == Items.GOLDEN_PICKAXE || item == Items.DIAMOND_PICKAXE || item == Items.NETHERITE_PICKAXE ||
                        item == Items.WOODEN_AXE     || item == Items.STONE_AXE     || item == Items.IRON_AXE     || item == Items.GOLDEN_AXE     || item == Items.DIAMOND_AXE     || item == Items.NETHERITE_AXE ||
                        item == Items.WOODEN_SHOVEL  || item == Items.STONE_SHOVEL  || item == Items.IRON_SHOVEL  || item == Items.GOLDEN_SHOVEL  || item == Items.DIAMOND_SHOVEL  || item == Items.NETHERITE_SHOVEL ||
                        item == Items.WOODEN_HOE     || item == Items.STONE_HOE     || item == Items.IRON_HOE     || item == Items.GOLDEN_HOE     || item == Items.DIAMOND_HOE     || item == Items.NETHERITE_HOE || isModAxe
        ) {
            blockBonus  += 0.75;
            entityBonus += 0.75;
        }

        // ===== 2. 剪刀 / 木棍 / 骨头 =====
        if (item == Items.SHEARS || isTinyAxe) {
            blockBonus  += 0.5;
            entityBonus += 0.5;
        }

        // ===== 3. 铁锭 =====
        if (item == ModItems.Nothing.get()) {
            blockBonus  += 1.0;
            entityBonus += 1.0;
        }

        // ===== 4. 金锭 =====
        if (item == ModItems.Nothing.get()) {
            blockBonus  += 0.25;
            entityBonus += 0.25;
        }

        apply(p, ForgeMod.BLOCK_REACH.get(),  BLOCK_UUID,  blockBonus);
        apply(p, ForgeMod.ENTITY_REACH.get(), ENTITY_UUID, entityBonus);
    }

    private static void apply(Player p, net.minecraft.world.entity.ai.attributes.Attribute attr, UUID id, double value) {
        var inst = p.getAttribute(attr);
        if (inst == null) return;

        inst.removeModifier(id);

        if (value != 0) {
            inst.addPermanentModifier(
                    new net.minecraft.world.entity.ai.attributes.AttributeModifier(
                            id, "mite_reach", value,
                            net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADDITION
                    )
            );
        }
    }
}
