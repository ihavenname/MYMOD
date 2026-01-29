//package com.FiF.MITE.run.network;
//
//import com.FiF.MITE.run.network.SpeedStateHandler;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraftforge.network.NetworkEvent;
//
//import java.util.function.Supplier;
//
//public class SpeedStopPacket {
//
//    public SpeedStopPacket() {}
//
//    public static void encode(SpeedStopPacket msg, FriendlyByteBuf buf) {}
//
//    public static SpeedStopPacket decode(FriendlyByteBuf buf) {
//        return new SpeedStopPacket();
//    }
//
//    public static void handle(SpeedStopPacket msg, Supplier<NetworkEvent.Context> ctx) {
//        ctx.get().enqueueWork(() -> {
//            ServerPlayer player = ctx.get().getSender();
//            if (player != null) {
//                SpeedStateHandler.setSpeed(player, false);
//            }
//        });
//        ctx.get().setPacketHandled(true);
//    }
//}
