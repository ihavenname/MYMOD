//package com.FiF.MITE.Health;
//
//import com.FiF.MITE.MITE;
//import net.minecraft.world.entity.ai.attributes.AttributeModifier;
//import net.minecraft.world.entity.ai.attributes.Attributes;
//import net.minecraft.world.entity.player.Player;
//import net.minecraftforge.event.entity.player.PlayerEvent;
//import net.minecraftforge.event.entity.player.PlayerXpEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//import java.util.UUID;
//
//@Mod.EventBusSubscriber(modid = MITE.MOD_ID)
//public class PlayerHealthFood1 {
//
//    private static final UUID LEVEL_HEALTH_UUID =
//            UUID.fromString("b8a8f6e1-9e57-4e1a-91f6-1d84d9f2f001");
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
//        // 原版是 20
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
//    }
//
//    // 登录
//    @SubscribeEvent
//    public static void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
//        apply(event.getEntity());
//    }
//
//    // 升级 / 降级
//    @SubscribeEvent
//    public static void onLevelChange(PlayerXpEvent.LevelChange event) {
//        apply(event.getEntity());
//    }
//
//    // 重生
//    @SubscribeEvent
//    public static void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
//        apply(event.getEntity());
//    }
//}
