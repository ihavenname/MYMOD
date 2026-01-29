//package com.FiF.MITE.BreakBlcok;
//
//import com.FiF.MITE.BreakBlcok.KeyBinds.KeyBindings;
//import net.minecraft.client.Minecraft;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.client.event.InputEvent;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import org.lwjgl.glfw.GLFW;
//
//@Mod.EventBusSubscriber(modid = "mite", value = Dist.CLIENT)
//public class ContinueLeftClick2 {
//
//    private static final Minecraft mc = Minecraft.getInstance();
//    private static boolean autoMining = false; // 自动挖掘状态
//    private static boolean miningActive = false; // 挖掘过程中状态
//
//    // 新增：用于检测右键“单击”
//    private static boolean lastRightDown = false;
//
//    // 按键事件：按一次 M 键切换自动挖掘开关
//    @SubscribeEvent
//    public static void onKey(InputEvent.Key event) {
//        if (mc.level == null || mc.player == null) return;
//
//        int key = event.getKey();
//        int action = event.getAction(); // GLFW_PRESS = 1
//
//        if (KeyBindings.AUTO_MINING.consumeClick()) {
//            autoMining = !autoMining; // 切换自动挖掘开关
//            miningActive = autoMining; // 如果开启自动挖掘，就标记为活动状态
//            if (!autoMining) {
//                mc.options.keyAttack.setDown(false); // 关闭时释放左键
//            }
//        }
//    }
//
//    // 每 tick 执行
//    @SubscribeEvent
//    public static void onClientTick(TickEvent.ClientTickEvent event) {
//        if (mc.level == null || mc.player == null) return;
//
//        long window = mc.getWindow().getWindow();
//
//        // ===== 新增：真实的“是否正在破坏方块” =====
//        boolean isDestroying = mc.gameMode != null && mc.gameMode.isDestroying();
//
//        // ===== 新增：右键单击检测 =====
//        boolean rightDownNow = GLFW.glfwGetMouseButton(window, GLFW.GLFW_MOUSE_BUTTON_RIGHT) == GLFW.GLFW_PRESS;
//        boolean rightClicked = rightDownNow && !lastRightDown;
//        lastRightDown = rightDownNow;
//
//        // ===== 新增：挖掘中 + 右键一次 → 开启自动挖掘 =====
//        if (!autoMining && isDestroying && rightClicked) {
//            autoMining = true;
//            miningActive = true;
//        }
//
//        // ===== 下面是你原本的逻辑，一行未改 =====
//
//        if (!autoMining) return; // 只有在自动挖掘状态才执行
//
//        // 检测玩家是否按下鼠标左右键，如果按下就取消自动挖掘
////        boolean leftDown = GLFW.glfwGetMouseButton(window, GLFW.GLFW_MOUSE_BUTTON_LEFT) == GLFW.GLFW_PRESS;
////        boolean rightDown = GLFW.glfwGetMouseButton(window, GLFW.GLFW_MOUSE_BUTTON_RIGHT) == GLFW.GLFW_PRESS;
////
////        if (leftDown ) {
////            autoMining = false;
////            miningActive = false;
////            mc.options.keyAttack.setDown(false);
////            return;
////        }
//
//        // 如果处于自动挖掘状态，模拟左键按住
//        if (miningActive) {
//            mc.options.keyAttack.setDown(true);
//        }
//    }
//}
