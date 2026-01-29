package com.FiF.MITE.run;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "mite")
public class JumpExhaustionHandler {

    // 你要的：120 秒 = 48 exhaustion
    // 原版站跳 ≈ 0.00425/tick → 564s
    // 你需要补到 ≈ 0.2 / jump
    private static final float EXTRA_JUMP_EXHAUSTION = 0.193f;

    @SubscribeEvent
    public static void onPlayerJump(LivingEvent.LivingJumpEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        if (player.getAbilities().instabuild) return;

        // 不是 sprint
        if (player.isSprinting()) return;

        // 不是 speed
        if (SpeedHandler2.isSpeedActive()) return;

        // 这一下是真正的“起跳”
        player.getFoodData().addExhaustion(EXTRA_JUMP_EXHAUSTION);
    }
}
