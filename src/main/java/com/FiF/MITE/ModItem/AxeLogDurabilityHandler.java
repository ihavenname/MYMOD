//package com.FiF.MITE.ModItem;
//
//import com.FiF.MITE.MITE;
//import net.minecraft.tags.BlockTags;
//import net.minecraft.world.entity.EquipmentSlot;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.AxeItem;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.event.level.BlockEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = MITE.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
//public class AxeLogDurabilityHandler {
//
//    @SubscribeEvent
//    public static void onBreak(BlockEvent.BreakEvent event) {
//        Player player = event.getPlayer();
//        if (player == null) return;
//        if (player.level().isClientSide) return;
//
//        BlockState state = event.getState();
//
//        // 只处理原木
//        if (!state.is(BlockTags.LOGS)) return;
//
//        ItemStack stack = player.getMainHandItem();
//        if (!(stack.getItem() instanceof AxeItem)) return;
//
//        int damage = getCustomAxeDamage(stack);
//
//        if (damage > 0) {
//            stack.hurtAndBreak(damage, player, p ->
//                    p.broadcastBreakEvent(EquipmentSlot.MAINHAND)
//            );
//        }
//    }
//
//    private static int getCustomAxeDamage(ItemStack stack) {
//        Item item = stack.getItem();
//
//        // Tiny 斧
//        if (item == ModItems.TINY_FIRE_ROCK_AXE.get() ||
//                item == ModItems.TINY_BLACK_GLASS__AXE.get()) {
//            return 13;
//        }
//
//        // 普通 Mod 斧
//        if (item == ModItems.FIRE_ROCK_AXE.get() ||
//                item == ModItems.BLACK_GLASS__AXE.get()) {
//            return 11;
//        }
//
//        // 其他斧子（原版/别的mod）保持原版行为
//        return 1;
//    }
//}
//
