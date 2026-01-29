//package com.FiF.MITE.run;
//
//import com.FiF.MITE.BreakBlcok.KeyBinds.SpeedHandler;
//import net.minecraftforge.client.event.ComputeFovModifierEvent;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//
//@Mod.EventBusSubscriber(modid = "mite", value = Dist.CLIENT)
//public class SpeedFovHandler {
//
//    @SubscribeEvent
//    public static void onComputeFov(ComputeFovModifierEvent event) {
//        // 只影响自己
//        if (event.getPlayer().isLocalPlayer() && SpeedHandler.isSpeedActive()) {
//            // 放大 FOV 30%，像原版疾跑
//            event.setNewFovModifier(event.getFovModifier() * 1.0f);
//        }
//    }
//}
