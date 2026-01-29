//package com.FiF.MITE.Health;
//
//import com.FiF.MITE.MITE;
//import net.minecraft.world.entity.ai.attributes.AttributeModifier;
//import net.minecraft.world.entity.ai.attributes.Attributes;
//import net.minecraft.world.entity.player.Player;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.event.entity.player.PlayerEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//@Mod.EventBusSubscriber(modid = MITE.MOD_ID)
//public class PlayerHealthFood2 {
//
//    private static final UUID LEVEL_HEALTH_UUID =
//            UUID.fromString("b8a8f6e1-9e57-4e1a-91f6-1d84d9f2f001");
//
//    // 记录上一次等级，解决 Forge 事件延迟
//    private static final Map<UUID, Integer> LAST_LEVEL = new HashMap<>();
//
//    // 每 5 级 +2，初始 6，上限 20
//    private static double getMaxHealthForLevel(int level) {
//        int steps = level / 5;
//        int value = 6 + steps * 2;
//        return Math.min(20, value);
//    }
//
//    private static void apply(Player player) {
//        double target = getMaxHealthForLevel(player.experienceLevel);
//
//        var attr = player.getAttribute(Attributes.MAX_HEALTH);
//        if (attr == null) return;
//
//        var old = attr.getModifier(LEVEL_HEALTH_UUID);
//        if (old != null) {
//            attr.removeModifier(old);
//        }
//
//        // 原版最大生命是 20
//        double delta = target - 20.0;
//
//        attr.addPermanentModifier(
//                new AttributeModifier(
//                        LEVEL_HEALTH_UUID,
//                        "MITE level health",
//                        delta,
//                        AttributeModifier.Operation.ADDITION
//                )
//        );
//
//        if (player.getHealth() > player.getMaxHealth()) {
//            player.setHealth(player.getMaxHealth());
//        }
//        // ⭐ 同步最大饥饿 = 最大生命
////        ((FoodDataExtension) player.getFoodData())
////                .mite_maxFood((int) player.getMaxHealth());
//    }
//
//    // 登录时初始化
//    @SubscribeEvent
//    public static void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
//        Player player = event.getEntity();
//        LAST_LEVEL.put(player.getUUID(), player.experienceLevel);
//        apply(player);
//    }
//
//    // 重生时同步
//    @SubscribeEvent
//    public static void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
//        Player player = event.getEntity();
//        LAST_LEVEL.put(player.getUUID(), player.experienceLevel);
//        apply(player);
//    }
//
//    // 核心：每 tick 精准检测等级变化
//    @SubscribeEvent
//    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
//        if (event.phase != TickEvent.Phase.END) return;
//
//        Player player = event.player;
//        UUID id = player.getUUID();
//
//        int current = player.experienceLevel;
//        int last = LAST_LEVEL.getOrDefault(id, current);
//
//        if (current != last) {
//            LAST_LEVEL.put(id, current);
//            apply(player);
//        }
//    }
//}
