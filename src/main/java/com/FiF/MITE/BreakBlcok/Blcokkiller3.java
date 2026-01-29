package com.FiF.MITE.BreakBlcok;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;

@Mod.EventBusSubscriber(modid = "mite", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Blcokkiller3 {

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        Level level = player.level();
        BlockState state = event.getState();

        Optional<BlockPos> posOpt = event.getPosition();
        if (posOpt.isEmpty()) return;
        BlockPos pos = posOpt.get();

        float hardness = state.getDestroySpeed(level, pos);
        if (hardness < 0) return;

        float originalSpeed = event.getOriginalSpeed();
        if (originalSpeed <= 0) return;

        // =========================================================
        // ★ 原版工具锁：方块需要工具但玩家工具不对 → 直接锁死
        // =========================================================
        boolean canHarvest = ForgeHooks.isCorrectToolForDrops(state, player);
        if (!canHarvest) {
            event.setNewSpeed(0.0F);
            return;
        }

        // =========================================================
        // ★ 强制木头类必须斧头（log / wood / stripped 统统包含）
        // =========================================================
        if (state.is(BlockTags.LOGS)) {
            if (!player.getMainHandItem().is(ItemTags.AXES)) {
                event.setNewSpeed(0.0F);
                return;
            }
        }

        // ===== 你原来的硬度规则层 =====
        float effectiveHardness = hardness;

        // 特例：0.6 → 0.5
        if (Math.abs(hardness - 0.6f) < 0.0001f) {
            effectiveHardness = 0.5f;
        }

        float baseHardness = hardness;
        if (hardness == 0.0f) {
            baseHardness = 1.0f;
        }

        float multiplier = (30.0f * baseHardness) / (512.0f * effectiveHardness);

        float newSpeed = originalSpeed * multiplier;

        // =========================================================
        // ★ MITE 等级加成，每级 2%，200级上限
        // ★ 原地计算 MITE 等级
        // =========================================================
        int totalExp = player.totalExperience;
        // 公式：5*n^2 + 15*n = totalExp -> n = (-3 + sqrt(9 + 0.8*totalExp)) / 2
        double n = (-3.0 + Math.sqrt(9.0 + 0.8 * totalExp)) / 2.0;
        int miteLevel = (int) Math.floor(n);

        int cappedLevel = Math.min(miteLevel, 200);
        float miteBonus = 1.0f + 0.02f * cappedLevel; // 每级 2%
        newSpeed *= miteBonus;

        // =========================================================
        // ★ 玩家趴下（匍匐）→ 挖掘速度减半
        // =========================================================
        if (player.getPose() == Pose.SWIMMING) {
            newSpeed *= 0.5f;
        }

        // =========================================================
        // ★ 饱食度为0 → 挖掘速度降低80%
        // =========================================================
        if (player.getFoodData().getFoodLevel() == 0) {
            newSpeed *= 0.2f; // 剩余 20% 的速度
        }

        event.setNewSpeed(newSpeed);
    }
}
