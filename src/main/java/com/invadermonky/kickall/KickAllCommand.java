package com.invadermonky.kickall;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KickAllCommand extends CommandBase {
    @Override
    public String getName() {
        return "kickall";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/kickall [message]";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(server.isSinglePlayer()) {
            throw new WrongUsageException("Cannot use command in single player worlds.");
        }

        String[] onlinePlayers = server.getOnlinePlayerNames();
        StringBuilder message = new StringBuilder();

        for(String arg : args) {
            message.append(" ").append(arg);
        }

        for(String playerName : onlinePlayers) {
            if(playerName.equals(sender.getName())) {
                continue;
            }
            String command = "kick " + playerName + message;
            server.commandManager.executeCommand(sender, command);
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
}
