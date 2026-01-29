package com.FiF.MITE.ModItem;

import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.BlockState;

public class ModShears extends ShearsItem {

    public ModShears(Item.Properties props) {
        super(props);
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState state) {
        // 原版剪刀能剪的 + Dead Bush
        return state.is(Blocks.COBWEB)
                || state.is(BlockTags.LEAVES)
                || state.getBlock() instanceof net.minecraft.world.level.block.VineBlock
                || state.is(Blocks.DEAD_BUSH); // 加上 Dead Bush
    }


}
