package com.FiF.MITE.run.network;

import com.FiF.MITE.run.HungerEffectHandler3;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SpeedJumpPacket {

    public SpeedJumpPacket() {}

    public static void encode(SpeedJumpPacket msg, FriendlyByteBuf buf) {}
    public static SpeedJumpPacket decode(FriendlyByteBuf buf) {
        return new SpeedJumpPacket();
    }

    public static void handle(SpeedJumpPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;

            // 在服务端标记“这 tick 触发了一次加速跳跃”
            HungerEffectHandler3.onSpeedJump(player);
        });
        ctx.get().setPacketHandled(true);
    }
}
