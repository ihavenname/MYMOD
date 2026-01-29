//package com.FiF.MITE.run.network;
//
//import net.minecraft.server.level.ServerPlayer;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class SpeedStateHandler {
//
//    private static final Set<ServerPlayer> speedPlayers = new HashSet<>();
//
//    public static void setSpeed(ServerPlayer player, boolean active) {
//        if (active) speedPlayers.add(player);
//        else speedPlayers.remove(player);
//    }
//
//    public static boolean isLocalSpeedActive(ServerPlayer player) {
//        return speedPlayers.contains(player);
//    }
//}
