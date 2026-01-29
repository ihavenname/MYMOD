package com.FiF.MITE.run.network;

import com.FiF.MITE.run.network.SpeedJumpPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class MITENetwork {

    private static final String PROTOCOL = "1";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("mite", "main"),
            () -> PROTOCOL,
            PROTOCOL::equals,
            PROTOCOL::equals
    );

    private static int id = 0;

    public static void register() {
        CHANNEL.registerMessage(
                id++,
                SpeedJumpPacket.class,
                SpeedJumpPacket::encode,
                SpeedJumpPacket::decode,
                SpeedJumpPacket::handle
        );
    }
}
