//package com.FiF.MITE.Health;
//
//import com.FiF.MITE.MITE;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.food.FoodData;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//@Mod.EventBusSubscriber(modid = MITE.MOD_ID)
//public class PlayerFoodLimiter {
//
//    // 🔒 唯一真实饱食度来源
//    public static final Map<UUID, MiteFoodState> FOOD = new HashMap<>();
//
//    @SubscribeEvent
//    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
//        if (event.phase != TickEvent.Phase.END) return;
//
//        Player player = event.player;
//        if (player.tickCount < 20) return;
//
//        UUID id = player.getUUID();
//
//        int max = (int) PlayerHealthFood3
//                .getMaxHealthForLevelFromExp(player.totalExperience);
//
//        // 初始化影子 food
//        MiteFoodState state = FOOD.computeIfAbsent(
//                id,
//                k -> new MiteFoodState(max, max)
//        );
//
//        // clamp（你自己的规则）
//        if (state.food > max) state.food = max;
//        if (state.saturation > max) state.saturation = max;
//        if (state.food < 0) state.food = 0;
//        if (state.saturation < 0) state.saturation = 0;
//
//        // 🚫 不读取原版，只写回
//        FoodData food = player.getFoodData();
//        food.setFoodLevel(state.food);
//        food.setSaturation(state.saturation);
//    }
//}
