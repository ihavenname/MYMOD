//package com.FiF.MITE.Health;
//
//import com.FiF.MITE.MITE;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.food.FoodProperties;
//import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//import java.util.UUID;
//
//@Mod.EventBusSubscriber(modid = MITE.MOD_ID)
//public class PlayerFoodEatHandler {
//
//    @SubscribeEvent
//    public static void onEat(LivingEntityUseItemEvent.Finish event) {
//        LivingEntity entity = event.getEntity();
//        if (!(entity instanceof Player player)) return;
//
//        FoodProperties prop = event.getItem().getFoodProperties(player);
//        if (prop == null) return;
//
//        UUID id = player.getUUID();
//        MiteFoodState state = PlayerFoodLimiter.FOOD.get(id);
//        if (state == null) return;
//
//        // 原版公式
//        state.food += prop.getNutrition();
//        state.saturation +=
//                prop.getNutrition() * prop.getSaturationModifier();
//    }
//}
