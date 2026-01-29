package com.FiF.MITE.block;

import com.FiF.MITE.MITE;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = MITE.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockGravity {

    @SubscribeEvent
    public static void onRegister(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.BLOCKS, helper -> {

            override(helper, Blocks.DIRT);
            override(helper, Blocks.SOUL_SAND);

        });
    }

    private static void override(RegisterEvent.RegisterHelper<Block> helper, Block original) {
        ResourceLocation id = ForgeRegistries.BLOCKS.getKey(original);

        if (id == null) return;

        Block newBlock = new FallingBlock(
                BlockBehaviour.Properties.copy(original)
        );

        helper.register(id, newBlock);
    }
}
