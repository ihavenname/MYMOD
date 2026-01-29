//package com.FiF.MITE.run;
//
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.sounds.SoundSource;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResultHolder;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.Level;
//import net.minecraftforge.event.entity.player.PlayerInteractEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber
//public class SeedEatHandler {
//
//    @SubscribeEvent
//    public static void onRightClick(PlayerInteractEvent.RightClickItem event) {
//        // 获取玩家对象
//        if (!(event.getEntity() instanceof Player)) return;
//        Player player = (Player) event.getEntity();
//
//        ItemStack stack = event.getItemStack();
//        Level world = player.level();
//
//        // 只处理服务端小麦种子
//        if (!world.isClientSide && stack.getItem() == Items.WHEAT_SEEDS) {
//
//            // 播放食用动画
//            player.startUsingItem(event.getHand());
//
//            // 执行食用逻辑
//            eatSeed(player, stack, world);
//
//            // 阻止原本右键逻辑
//            event.setCanceled(true);
//            event.setCancellationResult(InteractionResultHolder.success(stack).getResult());
//        }
//    }
//
//    private static void eatSeed(Player player, ItemStack stack, Level world) {
//        int foodLevel = player.getFoodData().getFoodLevel();
//
//        if (foodLevel > 0) {
//            // 饥饿值大于 0 → 只增加饱和度
//            float currentSaturation = player.getFoodData().getSaturationLevel();
//            float maxSaturation = foodLevel; // 饱和度不能超过当前饥饿值
//            player.getFoodData().setSaturation(Math.min(currentSaturation + 1.0f, maxSaturation));
//        } else {
//            // 饥饿值 = 0 → 增加 1 饥饿值，不增加饱和度
//            player.getFoodData().setFoodLevel(foodLevel + 1);
//        }
//
//        // 播放吃东西音效
//        world.playSound(null, player.getX(), player.getY(), player.getZ(),
//                SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 1.0f, 1.0f);
//
//        // 消耗种子
//        stack.shrink(1);
//    }
//}
