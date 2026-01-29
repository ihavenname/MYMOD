package com.FiF.MITE.Health;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class FullFoodRegen {

    private static final String TIMER = "MITE_FullFoodRegenTimer";
    private static final int INTERVAL = 1280; // 64 秒

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;
        if (player.level().isClientSide) return;

        FoodData food = player.getFoodData();
        int max = (int) player.getMaxHealth();

        CompoundTag data = player.getPersistentData();
        int timer = data.getInt(TIMER);

        // 只有满饱食度时才计时
        if (food.getFoodLevel() >= max && player.getHealth() < player.getMaxHealth()) {
            timer++;

            if (timer >= INTERVAL) {
                player.heal(1.0F);
                timer -= INTERVAL; // 继承余数
            }
        }

        // 不满时什么都不做 → timer 被“冻结”

        data.putInt(TIMER, timer);
    }
}
