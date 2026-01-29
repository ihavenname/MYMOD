package com.FiF.MITE.Health;

import com.FiF.MITE.MITE;
import net.minecraft.network.protocol.game.ClientboundSetHealthPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MITE.MOD_ID)
public class PlayerFoodLimiter2 {

    /**
     * 每 tick 限制玩家饱食度 ≤ 最大生命值，并同步客户端显示
     */
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        // 只处理 END 阶段
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;

        // 只在服务端处理
        if (player.level().isClientSide) return;

        FoodData food = player.getFoodData();
        int maxFood = (int) player.getMaxHealth(); // 最大生命值作为饱食度上限
        boolean changed = false;

        // 饱食度限制
        if (food.getFoodLevel() > maxFood) {
            food.setFoodLevel(maxFood);
            changed = true;
        }

        // 饱和度限制
        if (food.getSaturationLevel() > maxFood) {
            food.setSaturation(maxFood);
            changed = true;
        }

        // 同步给客户端
        if (changed && player instanceof ServerPlayer sp) {
            sp.connection.send(new ClientboundSetHealthPacket(
                    sp.getHealth(),
                    sp.getFoodData().getFoodLevel(),
                    sp.getFoodData().getSaturationLevel()
            ));
        }
    }
}
