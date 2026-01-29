//package com.FiF.MITE.Health;
//
//import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.event.entity.living.LivingEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.food.FoodData;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//
//@Mod("mite")
//public class food {
//
//    public food() {
//        MinecraftForge.EVENT_BUS.register(this);
//    }
//
//    @SubscribeEvent
//    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
//        if (event.phase == TickEvent.Phase.END) {
//            Player player = event.player;
//            FoodData foodData = player.getFoodData();
//
//            // 获取玩家的最大生命值，将其作为饱食度上限
//            double maxHealth = player.getMaxHealth();
//            int maxFoodLevel = (int) Math.floor(maxHealth);
//
//            // 限制饱食度在合理范围内（至少为1，不超过200以防止数值过大）
//            maxFoodLevel = Math.max(1, Math.min(maxFoodLevel, 200));
//
//            // 如果当前饱食度超过了新的上限，则降低到上限值
//            if (foodData.getFoodLevel() > maxFoodLevel) {
//                foodData.setFoodLevel(maxFoodLevel);
//            }
//
//            // 同时更新饱食度的饱和度上限
//            if (foodData.getSaturationLevel() > maxFoodLevel) {
//                foodData.setSaturation((float) maxFoodLevel);
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public void onLivingUpdate(LivingEvent.LivingTickEvent event) {
//        if (event.getEntity() instanceof Player) {
//            Player player = (Player) event.getEntity();
//            if (!player.level().isClientSide()) {
//                // 确保服务器端也同步更新
//                FoodData foodData = player.getFoodData();
//
//                double maxHealth = player.getMaxHealth();
//                int maxFoodLevel = (int) Math.floor(maxHealth);
//
//                maxFoodLevel = Math.max(1, Math.min(maxFoodLevel, 200));
//
//                if (foodData.getFoodLevel() > maxFoodLevel) {
//                    foodData.setFoodLevel(maxFoodLevel);
//
//                    if (foodData.getSaturationLevel() > maxFoodLevel) {
//                        foodData.setSaturation((float) maxFoodLevel);
//                    }
//                }
//            }
//        }
//    }
//}
//
//// 自定义FoodData扩展类
//class ExtendedFoodData extends FoodData {
//    private int dynamicMaxFoodLevel = 20; // 默认最大饱食度
//
//    public ExtendedFoodData() {
//        super();
//    }
//
//    // 设置动态最大饱食度
//    public void setDynamicMaxFoodLevel(double maxHealth) {
//        int newMax = (int) Math.floor(Math.max(1, Math.min(maxHealth, 200)));
//        this.dynamicMaxFoodLevel = newMax;
//
//        // 如果当前饱食度超过新上限，调整到上限
//        if (this.getFoodLevel() > newMax) {
//            this.setFoodLevel(newMax);
//        }
//
//        // 调整饱和度上限
//        if (this.getSaturationLevel() > newMax) {
//            this.setSaturation((float) newMax);
//        }
//    }
//
//    // 重写eat方法，确保不会超过动态上限
//    @Override
//    public void eat(int nutrition, float saturationModifier) {
//        int currentFood = this.getFoodLevel();
//        int newFoodLevel = Math.min(currentFood + nutrition, this.dynamicMaxFoodLevel);
//
//        this.setFoodLevel(newFoodLevel);
//
//        float newSaturation = Math.min(
//                this.getSaturationLevel() + (float) nutrition * saturationModifier * 2.0F,
//                Math.min((float) newFoodLevel, (float) this.dynamicMaxFoodLevel)
//        );
//
//        this.setSaturation(newSaturation);
//    }
//
//    // 获取当前动态最大饱食度
//    public int getDynamicMaxFoodLevel() {
//        return this.dynamicMaxFoodLevel;
//    }
//
//    // 检查是否需要食物（基于动态上限）
//    public boolean needsFood() {
//        return this.getFoodLevel() < this.dynamicMaxFoodLevel;
//    }
//}
//
//// 用于替换原版FoodData的处理器
//class FoodDataHandler {
//    public static ExtendedFoodData createExtendedFoodData() {
//        return new ExtendedFoodData();
//    }
//
//    public static void updatePlayerFoodData(Player player) {
//        if (player.getFoodData() instanceof ExtendedFoodData) {
//            ExtendedFoodData extFoodData = (ExtendedFoodData) player.getFoodData();
//            extFoodData.setDynamicMaxFoodLevel(player.getMaxHealth());
//        }
//    }
//}
