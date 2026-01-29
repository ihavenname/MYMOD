//package com.FiF.MITE.run.network;
//
//import com.FiF.MITE.run.network.SpeedStateHandler;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraftforge.network.NetworkEvent;
//
//import java.util.function.Supplier;
//
//public class SpeedStartPacket {
//
//    // Forge 需要一个无参构造器
//    public SpeedStartPacket() {}
//
//    public static void encode(SpeedStartPacket msg, FriendlyByteBuf buf) {
//        // 不需要写任何数据
//    }
//
//    public static SpeedStartPacket decode(FriendlyByteBuf buf) {
//        return new SpeedStartPacket();
//    }
//
//    public static void handle(SpeedStartPacket msg, Supplier<NetworkEvent.Context> ctx) {
//        ctx.get().enqueueWork(() -> {
//            ServerPlayer player = ctx.get().getSender();
//            if (player != null) {
//                SpeedStateHandler.setSpeed(player, true);
//            }
//        });
//        ctx.get().setPacketHandled(true);
//    }
//}
