//package com.FiF.MITE.block;
//
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.event.entity.player.PlayerEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = "mite")
//public class MiningRule {
//
//    @SubscribeEvent
//    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
//        Player player = event.getEntity();
//        BlockState state = event.getState();
//
//        // 只管那些“需要正确工具”的方块
//        if (!state.requiresCorrectToolForDrops()) return;
//
//        ItemStack tool = player.getMainHandItem();
//
//        // Forge/Mojang 原生判断：这个工具能不能挖这个方块
//        if (!tool.isCorrectToolForDrops(state)) {
//            // 设为 0 = 像基岩一样挖不动
//            event.setNewSpeed(0.0F);
//        }
//    }
//}
//
