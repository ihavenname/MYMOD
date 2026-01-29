//package com.FiF.MITE.GrassBreak;
//
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.world.item.BlockItem;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.block.TallGrassBlock;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.event.entity.player.PlayerInteractEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = "mite", bus = Mod.EventBusSubscriber.Bus.FORGE)
//public class GrassBreakEvents {
//
//    /** 右键草：启动挖草 */
//    @SubscribeEvent
//    public static void onRightClickGrass(PlayerInteractEvent.RightClickBlock event) {
//        if (!(event.getLevel() instanceof ServerLevel level)) return;
//
//        if (!(level.getBlockState(event.getPos()).getBlock() instanceof TallGrassBlock)) return;
//
//        ItemStack stack = event.getItemStack();
//
//        // 🟩 手里是方块 → 原版行为
//        if (stack.getItem() instanceof BlockItem) {
//            return;
//        }
//
//        // 🟥 非方块 → 自定义挖草
//        GrassBreakManager.tick(event.getEntity(), event.getPos());
//
//        // 阻止原版（防止 replaceable）
//        event.setCanceled(true);
//    }
//
//    /** 每 tick 维持“持续右键” */
//    @SubscribeEvent
//    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
//        if (event.phase != TickEvent.Phase.END) return;
//
//        if (!event.player.isUsingItem()) {
//            GrassBreakManager.reset(event.player);
//        }
//    }
//}
