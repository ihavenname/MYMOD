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
//public class SlowSeedEatHandler2 {
//
//    // 食用持续时间（ticks），原版苹果是 32 ticks
//    private static final int USE_DURATION = 32;
//
//    @SubscribeEvent
//    public static void onRightClick(PlayerInteractEvent.RightClickItem event) {
//        if (!(event.getEntity() instanceof Player)) return;
//        Player player = (Player) event.getEntity();
//
//        ItemStack stack = event.getItemStack();
//        Level world = player.level();
//
//        // 只处理服务端小麦种子
//        if (!world.isClientSide && stack.getItem() == Items.WHEAT_SEEDS) {
//
//            // 启动食用动作，慢慢吃
//            player.startUsingItem(event.getHand());
//
//            // 标记事件已处理
//            event.setCanceled(true);
//            event.setCancellationResult(InteractionResultHolder.consume(stack).getResult());
//        }
//    }
//
//    /**
//     * 在 tick 或使用完成时调用的处理方法
//     * 这里模拟原版食物效果
//     */
//    public static void onFinishUse(Player player, ItemStack stack) {
//        Level world = player.level();
//        int foodLevel = player.getFoodData().getFoodLevel();
//
//        if (foodLevel > 0) {
//            // 饥饿值大于 0 → 只增加饱和度
//            float currentSaturation = player.getFoodData().getSaturationLevel();
//            float maxSaturation = foodLevel; // 饱和度不能超过当前饥饿值
//            player.getFoodData().setSaturation(Math.min(currentSaturation + 1.0f, maxSaturation));
//        } else {
//            // 饥饿值 = 0 → 增加 1 点饥饿值，不增加饱和度
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
