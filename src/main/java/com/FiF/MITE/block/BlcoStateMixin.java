//package com.FiF.MITE.block;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.tags.BlockTags;
//import net.minecraft.tags.ItemTags;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.block.RotatedPillarBlock;
//import net.minecraft.world.level.block.state.BlockBehaviour;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.common.ForgeHooks;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(ForgeHooks.class)
//public class BlcoStateMixin {
//
//    @Inject(
//            method = "isCorrectToolForDrops",
//            at = @At("HEAD"),
//            cancellable = true,
//            remap = false
//    )
//    private static void forceVanillaToolRules(BlockState state, Player player, CallbackInfoReturnable<Boolean> cir) {
//        if (player == null) return;
//
//        // 木头必须斧头
//        if (state.is(BlockTags.LOGS)) {
//            if (!player.getMainHandItem().is(ItemTags.AXES)) {
//                cir.setReturnValue(false);
//                return;
//            }
//        }
//
//        // 石头、矿物必须镐
//        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) {
//            if (!player.getMainHandItem().is(ItemTags.PICKAXES)) {
//                cir.setReturnValue(false);
//            }
//        }
//
//        // 铲子类
//        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
//            if (!player.getMainHandItem().is(ItemTags.SHOVELS)) {
//                cir.setReturnValue(false);
//            }
//        }
//    }
//}
//
//
//
//
