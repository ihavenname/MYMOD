package com.FiF.MITE.run;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.food.FoodData;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = "mite")
public class HungerEffectHandler3 {

    private static final Set<ServerPlayer> boostedJump = new HashSet<>();

    // 被 SpeedJumpPacket 调用
    public static void onSpeedJump(ServerPlayer player) {
        boostedJump.add(player);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (!(event.player instanceof ServerPlayer player)) return;
        if (event.phase != TickEvent.Phase.END) return;

        if (boostedJump.remove(player)) {
            FoodData food = player.getFoodData();
            food.addExhaustion(0.65F);   // ⭐ 每次增强跳跃消耗
        }
    }
}
