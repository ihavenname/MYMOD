//package com.FiF.MITE.mixin;
//
//
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.item.enchantment.Enchantment;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(Enchantment.class)
//public abstract class EnchantmentMixin {
//
//    @Inject(
//            method = "canApplyAtEnchantingTable(Lnet/minecraft/world/item/ItemStack;)Z",
//            at = @At("HEAD"),
//            cancellable = true
//    )
//    private void allowIronIngotEnchantItem(net.minecraft.world.item.ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
//        if (stack.is(net.minecraft.world.item.Items.IRON_INGOT)) {
//            cir.setReturnValue(true); // 永远允许铁锭附魔
//        }
//    }
//}
//
//
