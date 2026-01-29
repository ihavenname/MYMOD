package com.FiF.MITE.Health;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DisableGameRule {

    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        if (!(event.getLevel() instanceof ServerLevel level)) return;

        // 关闭自然回血
        level.getGameRules().getRule(GameRules.RULE_NATURAL_REGENERATION)
                .set(false, level.getServer());

        level.getGameRules().getRule(GameRules.RULE_DOINSOMNIA)
                .set(false, level.getServer());

        level.getGameRules().getRule(GameRules.RULE_DO_PATROL_SPAWNING)
                .set(false, level.getServer());

        level.getGameRules().getRule(GameRules.RULE_DO_TRADER_SPAWNING)
                .set(false, level.getServer());

        level.getGameRules().getRule(GameRules.RULE_DO_WARDEN_SPAWNING)
                .set(false, level.getServer());
    }
}
