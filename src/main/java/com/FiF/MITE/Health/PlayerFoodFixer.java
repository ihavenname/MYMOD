//package com.FiF.MITE.Health;
//
//import com.FiF.MITE.MITE;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.food.FoodData;
//import net.minecraftforge.event.entity.player.PlayerEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = MITE.MOD_ID)
//public class PlayerFoodFixer {
//
//    @SubscribeEvent
//    public static void onLoad(PlayerEvent.LoadFromFile event) {
//        Player player = event.getEntity();
//
//        int max = (int) PlayerHealthFood3.getMaxHealthForLevelFromExp(player.totalExperience);
//        FoodData food = player.getFoodData();
//
//        if (food.getFoodLevel() > max) {
//            food.setFoodLevel(max);
//        }
//        if (food.getSaturationLevel() > max) {
//            food.setSaturation(max);
//        }
//    }
//}
