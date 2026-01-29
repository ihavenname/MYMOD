package com.FiF.MITE.Commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.util.Collection;
import java.util.function.Supplier;

import static net.minecraft.commands.Commands.literal;

public class XpCommand{

    public static LiteralArgumentBuilder<CommandSourceStack> register() {
        return literal("mitelevel")
                .executes(ctx -> {
                    ServerPlayer player = ctx.getSource().getPlayerOrException();
                    int miteLevel = getMiteLevel(player.totalExperience);
                    player.sendSystemMessage(Component.literal("你的 MITE 等级: " + miteLevel));
                    return Command.SINGLE_SUCCESS;
                })
                .then(Commands.argument("player", EntityArgument.players())
                        .executes(ctx -> {
                            Collection<ServerPlayer> players = EntityArgument.getPlayers(ctx, "player");
                            for (ServerPlayer target : players) {
                                int miteLevel = getMiteLevel(target.totalExperience);
                                ctx.getSource().sendSuccess(
                                        (Supplier<Component>) Component.literal(target.getName().getString() + " 的 MITE 等级: " + miteLevel),
                                        false
                                );
                            }
                            return Command.SINGLE_SUCCESS;
                        })
                );
    }

    /**
     * 根据总经验计算 MITE 等级
     * 公式: 5*n^2 + 15*n = totalExp
     */
    public static int getMiteLevel(int totalExp) {
        double n = (-3.0 + Math.sqrt(9.0 + 0.8 * totalExp)) / 2.0;
        return (int) Math.floor(n);
    }
}
