package com.FiF.MITE.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilScreen.class)
public abstract class AnvilScreenMixin {

    /**
     * @author cj
     * @reason
     *  保留 “Too Expensive”
     *  隐藏 “花费 X 级经验”
     */
    @Inject(
            method = "renderLabels",
            at = @At("HEAD"),
            cancellable = true
    )
    private void mite$hideXpCostOnly(
            GuiGraphics graphics,
            int mouseX,
            int mouseY,
            CallbackInfo ci
    ) {
        AnvilScreen self = (AnvilScreen)(Object)this;
        AnvilMenu menu = self.getMenu();
        Minecraft mc = Minecraft.getInstance();

        int cost = menu.getCost();
        ItemStack left = menu.getSlot(0).getItem(); // 铁砧左边的物品

        // ⚠ 条件：
        // 1. 左边不是金苹果 → 隐藏经验花费（取消 renderLabels）
        // 2. 左边是金苹果 → 放行，让原版显示经验
        // 3. Too Expensive 始终放行
        if (left.getItem() != Items.GOLDEN_APPLE
                && cost > 0
                && !(cost >= 40 && !mc.player.getAbilities().instabuild)) {
            ci.cancel();
        }
    }
}
