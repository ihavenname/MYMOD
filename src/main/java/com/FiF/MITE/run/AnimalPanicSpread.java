//package com.FiF.MITE.run;
//
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.ai.memory.MemoryModuleType;
//import net.minecraft.world.entity.animal.Animal;
//import net.minecraft.world.damagesource.DamageSource;
//import net.minecraft.world.phys.AABB;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.event.entity.living.LivingHurtEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//import java.util.List;
//
//@Mod.EventBusSubscriber(modid = "mite")
//public class AnimalPanicSpread {
//
//    private static final double PANIC_RADIUS = 8.0D;
//
//    /**
//     * Step 1:
//     * 当动物被伤害时，把它放进队列
//     */
//    @SubscribeEvent
//    public static void onAnimalHurt(LivingHurtEvent event) {
//        if (!(event.getEntity() instanceof Animal animal)) return;
//        if (animal.level().isClientSide) return;
//
//        PanicQueue.add(animal);
//    }
//
//    /**
//     * Step 2:
//     * 在服务器 tick 结束时，把恐慌传播给周围动物
//     */
//    @SubscribeEvent
//    public static void onServerTick(TickEvent.ServerTickEvent event) {
//        if (event.phase != TickEvent.Phase.END) return;
//
//        for (Animal hurt : PanicQueue.QUEUE) {
//            if (hurt.isRemoved()) continue;
//            LivingEntity attacker = hurt.getLastHurtByMob();
//            if (attacker == null) continue;
//
//            DamageSource source = hurt.getLastDamageSource();
//            if (source == null) continue;
//
//            AABB area = hurt.getBoundingBox().inflate(PANIC_RADIUS);
//            List<Animal> animals = hurt.level().getEntitiesOfClass(Animal.class, area);
//
//            for (Animal other : animals) {
//                if (other == hurt) continue;
//
//                // 这两行 = Mojang 原版恐慌触发条件
//                other.getBrain().setMemory(MemoryModuleType.HURT_BY, source);
//                other.getBrain().setMemory(MemoryModuleType.HURT_BY_ENTITY, attacker);
//            }
//        }
//
//        PanicQueue.clear();
//    }
//}
