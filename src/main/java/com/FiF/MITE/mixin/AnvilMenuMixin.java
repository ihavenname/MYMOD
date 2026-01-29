package com.FiF.MITE.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AnvilMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AnvilMenu.class)
public abstract class AnvilMenuMixin {

    /**
     * @author cj
     * @reason 禁止铁砧使用次数导致 RepairCost 指数增长
     */
    @Redirect(
            method = "createResult",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/inventory/AnvilMenu;calculateIncreasedRepairCost(I)I"
            )
    )
    private int mite$noRepairCostIncrease(int oldCost) {
        // 原样返回，不再 *2 + 1
        return oldCost;
    }

    /**
     * @author cj
     * @reason 铁砧操作不消耗经验
     */
    @Redirect(
            method = "onTake",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/player/Player;giveExperienceLevels(I)V"
            )
    )
    private void mite$noXpCost(Player player, int level) {
        // 什么都不做 = 不扣经验
    }
}
