package com.FiF.MITE.run;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.food.FoodData;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.FiF.MITE.run.SpeedHandler2.speedActive;

@Mod.EventBusSubscriber(modid = "mite")
public class HungerEffectHandler2 {

    // 每 tick 增加多少 exhaustion
    // 原版：疾跑是 0.1f / tick
    // 你要“39级饥饿”≈ 40倍
    private static final float SPEED_EXHAUSTION = 0.017f; // = 4.0

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (!(event.player instanceof ServerPlayer player)) return;
        if (event.phase != TickEvent.Phase.END) return;

        if (speedActive) {
            FoodData food = player.getFoodData();

            // 直接增加消耗
            food.addExhaustion(SPEED_EXHAUSTION);
        }
    }
}
