package net.craftstars.general.command;

import org.bukkit.command.Command;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Handles a command.
 * 
 * @author Plutonium239
 */
public final class GeneralTestCommand extends AbstractCommand
{
    @Override
    public Boolean fromPlayer(Plugin plugin, Player sender, Command command, String commandLabel, String[] args)
    {
        return false;
    }

    @Override
    public Boolean fromConsole(Plugin plugin, ConsoleCommandSender sender, Command command, String commandLabel, String[] args)
    {
        return false;
    }
}