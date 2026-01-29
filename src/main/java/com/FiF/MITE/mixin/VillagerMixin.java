package com.FiF.MITE.mixin;

import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = Villager.class)
public abstract class VillagerMixin {

    /**
     * 拦截生成经验球，但保留 villagerXp 和升级逻辑
     */
    @Redirect(
            method = "rewardTradeXp",
            at = @At(
                    value = "NEW",
                    target = "net/minecraft/world/entity/ExperienceOrb"
            )
    )
    private ExperienceOrb preventXpOrbSpawn(Level level, double x, double y, double z, int xp) {
        // 不生成经验球
        return null;
    }
}
