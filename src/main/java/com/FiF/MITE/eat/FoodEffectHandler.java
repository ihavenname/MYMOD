package com.FiF.MITE.eat;

import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = "mite")
public class FoodEffectHandler {

    @SubscribeEvent
    public static void onItemFinishUse(LivingEntityUseItemEvent.Finish event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        ItemStack stack = event.getItem();

        // 金苹果
        if (stack.is(Items.GOLDEN_APPLE)) {
            Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(stack);

            if (enchants.isEmpty()) {
                // 普通金苹果：生命恢复 I，60 秒
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20*60, 0));
            } else {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20 * 60, 1)); // II
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20 * 60, 0)); // I
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20 * 60, 0)); // I
            }
        }

        // 腐肉
        if (stack.is(Items.ROTTEN_FLESH) && player.getRandom().nextFloat() < 0.8F) {
            player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20*31, 0));
        }

        // 蜘蛛眼
        if (stack.is(Items.SPIDER_EYE)) {
            player.addEffect(new MobEffectInstance(MobEffects.POISON, 20*5, 0));
        }
    }
}

