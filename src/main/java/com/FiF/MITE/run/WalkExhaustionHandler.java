package com.FiF.MITE.run;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.WeakHashMap;

@Mod.EventBusSubscriber(modid = "mite")
public class WalkExhaustionHandler {

    // 保存玩家上一次位置
    private static final WeakHashMap<Player, double[]> lastPosMap = new WeakHashMap<>();

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player.level().isClientSide()) return;

        Player player = event.player;

        // 普通走路条件：
        // 1. 不疾跑
        // 2. 不游泳
        // 3. 不骑乘
        // 4. 不创造模式飞行
        // 5. 不 Elytra 飞行
        // 6. 在地面
        if (!SpeedHandler2.isSpeedActive() &&
                !player.isSwimming() &&
                !player.isPassenger() &&
                !player.getAbilities().flying &&
                !player.isFallFlying() &&
                player.onGround()) {

            double[] lastPos = lastPosMap.get(player);
            double x = player.getX();
            double z = player.getZ();

            if (lastPos != null) {
                double dx = x - lastPos[0];
                double dz = z - lastPos[1];
                double distanceSq = dx * dx + dz * dz;

                if (distanceSq > 0.0001) { // 阈值可调，玩家走路就能触发
                    player.getFoodData().addExhaustion(0.0057f);
                }
            }

            // 更新位置
            lastPosMap.put(player, new double[]{x, z});
        } else {
            // 玩家不走路时，也更新位置，防止瞬移或重生导致异常
            lastPosMap.put(player, new double[]{player.getX(), player.getZ()});
        }
    }
}
