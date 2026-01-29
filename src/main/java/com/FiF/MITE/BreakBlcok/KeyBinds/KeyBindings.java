package com.FiF.MITE.BreakBlcok.KeyBinds;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = "mite", bus = Mod.EventBusSubscriber.Bus.MOD)
public class KeyBindings {

    public static KeyMapping AUTO_MINING;
    public static KeyMapping SPEED_TOGGLE;

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        AUTO_MINING = new KeyMapping(
                "key.mite.auto_mining",        // 翻译键
                InputConstants.Type.KEYSYM,    // 输入类型（键盘）
                GLFW.GLFW_KEY_M,               // 默认按键
                "key.categories.mite"          // 分类（按键选项里的分组）
        );

        event.register(AUTO_MINING); // 注册到游戏

        SPEED_TOGGLE = new KeyMapping(
                "key.mite.speed_toggle",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_CONTROL,  // 你想用的按键
                "key.categories.mite"
        );
        event.register(SPEED_TOGGLE);
    }
}
