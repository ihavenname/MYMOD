package com.FiF.MITE.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.ForgeEventFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Zombie.class)
public abstract class ZombieMixin {

    @Inject(
            method = "killedEntity(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;)Z",
            at = @At("HEAD"),
            cancellable = true
    )



    private void mite$forceVillagerConversion(
            ServerLevel level,
            LivingEntity entity,
            CallbackInfoReturnable<Boolean> cir
    ) {
        // 只处理村民
        if (!(entity instanceof Villager villager)) {
            return;
        }

        // 尊重 Forge 转换事件（防止其他 mod 冲突）
        if (!ForgeEventFactory.canLivingConvert(
                entity,
                EntityType.ZOMBIE_VILLAGER,
                (timer) -> {}
        )) {
            return;
        }

        // 强制转换
        ZombieVillager zombieVillager =
                villager.convertTo(EntityType.ZOMBIE_VILLAGER, false);

        if (zombieVillager == null) {
            return;
        }

        // ↓↓↓ 以下全部是原版复制逻辑 ↓↓↓

        zombieVillager.finalizeSpawn(
                level,
                level.getCurrentDifficultyAt(zombieVillager.blockPosition()),
                MobSpawnType.CONVERSION,
                new Zombie.ZombieGroupData(false, true),
                (CompoundTag) null
        );

        zombieVillager.setVillagerData(villager.getVillagerData());
        zombieVillager.setGossips(villager.getGossips().store(NbtOps.INSTANCE));
        zombieVillager.setTradeOffers(villager.getOffers().createTag());
        zombieVillager.setVillagerXp(villager.getVillagerXp());

        ForgeEventFactory.onLivingConvert(entity, zombieVillager);

        Zombie zombie = (Zombie) (Object) this;
        if (!zombie.isSilent()) {
            level.levelEvent((Player) null, 1026, zombie.blockPosition(), 0);
        }

        // 关键：阻止原方法继续
        // false = 本次击杀被“转换逻辑接管”，村民不会死亡
        cir.setReturnValue(false);
    }

}
