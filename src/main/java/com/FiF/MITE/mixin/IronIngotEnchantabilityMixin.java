//package com.FiF.MITE.mixin;
//
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.Items;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(Item.class)
//public abstract class IronIngotEnchantabilityMixin {
//
//    @Inject(method = "getEnchantmentValue", at = @At("HEAD"), cancellable = true)
//    private void ironIngotEnchantability(CallbackInfoReturnable<Integer> cir) {
//        if ((Item)(Object)this == Items.IRON_INGOT) {
//            cir.setReturnValue(30); // 附魔等级，可调，越高附魔等级越强
//        }
//    }
//}
