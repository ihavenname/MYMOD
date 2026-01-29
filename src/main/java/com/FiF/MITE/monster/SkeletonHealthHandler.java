package com.FiF.MITE.monster;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Stray;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "mite")
public class SkeletonHealthHandler {

    @SubscribeEvent
    public static void onSkeletonJoin(EntityJoinLevelEvent event) {
        if (!(event.getEntity() instanceof Skeleton
                || event.getEntity() instanceof Stray)) return;

        var mob = (net.minecraft.world.entity.Mob) event.getEntity();

        AttributeInstance maxHealth = mob.getAttribute(Attributes.MAX_HEALTH);
        if (maxHealth != null) {
            maxHealth.setBaseValue(6.0D);
            mob.setHealth(6.0F);
        }
    }
}
