package com.FiF.MITE.BreakBlcok;

import com.FiF.MITE.BreakBlcok.KeyBinds.KeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = "mite", value = Dist.CLIENT)
public class ContinueLeftClick4 {

    private static final Minecraft mc = Minecraft.getInstance();
    private static boolean autoMining = false; // 自动挖掘状态
    private static boolean miningActive = false; // 挖掘过程中状态

    // 新增：用于检测右键“单击”
    private static boolean lastRightDown = false;

    // 新增：用于检测左键“单击”
    private static boolean lastLeftDown = false;

    // 新增：监听玩家加入游戏事件
    @SubscribeEvent
    public static void onPlayerJoin(net.minecraftforge.client.event.ClientPlayerNetworkEvent.LoggingIn event) {
        // 玩家进入存档时，将 lastLeftDown 设置为 true
        lastLeftDown = true;
//        lastRightDown = true;
    }

    // 按键事件：按一次 M 键切换自动挖掘开关
    @SubscribeEvent
    public static void onKey(InputEvent.Key event) {
        if (mc.level == null || mc.player == null) return;

        if (KeyBindings.AUTO_MINING.consumeClick()) {
            autoMining = !autoMining; // 切换自动挖掘开关
            miningActive = autoMining; // 如果开启自动挖掘，就标记为活动状态
            if (!autoMining) {
                mc.options.keyAttack.setDown(false); // 关闭时释放左键
            }
        }
    }

    // 每 tick 执行
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (mc.level == null || mc.player == null) return;

        long window = mc.getWindow().getWindow();

        // ===== 真实的“是否正在破坏方块” =====
        boolean isDestroying = mc.gameMode != null && mc.gameMode.isDestroying();

        // ===== 右键单击检测 =====
        boolean rightDownNow = GLFW.glfwGetMouseButton(window, GLFW.GLFW_MOUSE_BUTTON_RIGHT) == GLFW.GLFW_PRESS;
        boolean rightClicked = rightDownNow && !lastRightDown;
        lastRightDown = rightDownNow;

        // ===== 挖掘中 + 右键一次 → 开启自动挖掘 =====
        if (!autoMining && isDestroying && rightClicked) {
            autoMining = true;
            miningActive = true;
        }

        // ===== 原有逻辑 =====
        if (!autoMining) return;

        // ===== 左键单击检测（修复自杀 Bug） =====
        boolean leftDownNow = GLFW.glfwGetMouseButton(window, GLFW.GLFW_MOUSE_BUTTON_LEFT) == GLFW.GLFW_PRESS;
        boolean leftClicked = leftDownNow && !lastLeftDown;
        lastLeftDown = leftDownNow;

        // 左键“重新点击”才取消自动挖掘
        if (leftClicked) {
            autoMining = false;
            miningActive = false;
            mc.options.keyAttack.setDown(false);
            return;
        }

        // ===== 执行自动挖掘 =====
        if (miningActive) {
            mc.options.keyAttack.setDown(true);
        }
    }
}
