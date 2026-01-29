package com.FiF.MITE.Health;

import com.FiF.MITE.MITE;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = MITE.MOD_ID)
public class PlayerHealthFood3 {

    private static final UUID LEVEL_HEALTH_UUID =
            UUID.fromString("b8a8f6e1-9e57-4e1a-91f6-1d84d9f2f001");

    // 记录上一次等级，解决 Forge 事件延迟
    private static final Map<UUID, Integer> LAST_LEVEL = new HashMap<>();

    /**
     * 根据玩家总经验计算 MITE 等级，每 5 级 +2 最大生命
     * MITE 等级公式：
     * 总经验 E_total = 5*n^2 + 15*n
     */
    private static double getMaxHealthForLevel(int expLevel) {
        // 获取玩家当前总经验
        int exp = expLevel; // Minecraft 的 experienceLevel 只返回等级，不是总经验
        // ⚠️ 这里需要玩家总经验而不是 experienceLevel，Forge 提供 player.totalExperience
        // 所以 apply 方法中调用 getMaxHealthForLevel(player.totalExperience)

        return getMaxHealthForLevelFromExp(exp);
    }

    public static double getMaxHealthForLevelFromExp(int exp) {
        // 根据总经验反推 MITE 等级 n
        // 5*n^2 + 15*n = exp -> n = (-3 + sqrt(9 + 0.8*exp))/2
        double n = (-3.0 + Math.sqrt(9.0 + 0.8 * exp)) / 2.0;
        int miteLevel = (int) Math.floor(n);

        // 每 5 级 MITE 等级 +2 最大生命，初始 6
        int steps = miteLevel / 5;
        int value = 6 + steps * 2;

        // 最大生命上限 20
        return Math.min(20, value);
    }

    private static void apply(Player player) {
        double target = getMaxHealthForLevelFromExp(player.totalExperience);

        var attr = player.getAttribute(Attributes.MAX_HEALTH);
        if (attr == null) return;

        var old = attr.getModifier(LEVEL_HEALTH_UUID);
        if (old != null) {
            attr.removeModifier(old);
        }

        // 原版最大生命是 20
        double delta = target - 20.0;

        attr.addPermanentModifier(
                new AttributeModifier(
                        LEVEL_HEALTH_UUID,
                        "MITE level health",
                        delta,
                        AttributeModifier.Operation.ADDITION
                )
        );

        if (player.getHealth() > player.getMaxHealth()) {
            player.setHealth(player.getMaxHealth());
        }

        /* ========== ⭐ 同步饱食度上限 = 最大生命 ========== */
        int maxFood = (int) player.getMaxHealth();

        FoodData food = player.getFoodData();
        if (food instanceof FoodDataExtension ext) {
            ext.mite_setMaxFoodLevel(maxFood);
        }

        // ⭐ 同步最大饥饿 = 最大生命
//        ((FoodDataExtension) player.getFoodData())
//                .mite_maxFood((int) player.getMaxHealth());
        // 强制在 MAX_HEALTH 更新后同步 food 上限
//        int maxFood = (int) getMaxHealthForLevelFromExp(player.totalExperience);
//
//        FoodData food = player.getFoodData();
//
//        if (food.getFoodLevel() > maxFood) {
//            food.setFoodLevel(maxFood);
//        }
//
//        if (food.getSaturationLevel() > maxFood) {
//            food.setSaturation(maxFood);
//        }
    }

    // 登录时初始化
    @SubscribeEvent
    public static void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        LAST_LEVEL.put(player.getUUID(), player.experienceLevel);
        apply(player);
    }

    // 重生时同步
    @SubscribeEvent
    public static void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();
        LAST_LEVEL.put(player.getUUID(), player.experienceLevel);
        apply(player);
    }

    // 核心：每 tick 精准检测等级变化
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;
        UUID id = player.getUUID();

        int current = player.experienceLevel;
        int last = LAST_LEVEL.getOrDefault(id, current);

        if (current != last) {
            LAST_LEVEL.put(id, current);
            apply(player);
        }
    }
}
