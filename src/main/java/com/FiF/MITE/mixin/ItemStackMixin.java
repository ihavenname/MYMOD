//package com.FiF.MITE.mixin;
//
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.item.enchantment.Enchantment;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(ItemStack.class)
//public abstract class ItemStackMixin {
//
//    @Inject(
//            method = "canApplyAtEnchantingTable(Lnet/minecraft/world/item/enchantment/Enchantment;)Z",
//            at = @At("HEAD"),
//            cancellable = true
//    )
//    private void allowIronIngotEnchant(Enchantment ench, CallbackInfoReturnable<Boolean> cir) {
//        if (((ItemStack)(Object)this).is(Items.IRON_INGOT)) {
//            cir.setReturnValue(true);
//        }
//    }
//}
//
