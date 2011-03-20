package net.craftstars.general.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Abstract class that must be inherited in commands.
 *
 * @author Plutonium239
 */
public abstract class AbstractCommand
{
    /**
     * Deal with executing the incoming command.
     * 
     * @param plugin       the plugin running the command
     * @param sender       the command sender
     * @param command      the command object
     * @param commandLabel the actual command issued (alias)
     * @param args         the command arguments
     * 
     * @return Boolean     True if the command was successful. False otherwise.
     */
    public Boolean executeCommand(Plugin plugin, CommandSender sender, Command command, String commandLabel, String[] args)
    {
        if (sender instanceof Player)
        {
            return this.fromPlayer(plugin, (Player) sender, command, commandLabel, args);
        }
        else if (sender instanceof ConsoleCommandSender)
        {
            return this.fromConsole(plugin, (ConsoleCommandSender) sender, command, commandLabel, args);
        }
        
        return false;
    }
    
    /**
     * Deal with commands coming from players.
     * 
     * @param plugin
     * @param sender
     * @param command
     * @param commandLabel
     * @param args
     * 
     * @return Boolean
     */
    public abstract Boolean fromPlayer(Plugin plugin, Player sender, Command command, String commandLabel, String[] args);
    
    /**
     * Deal with commands coming from the console.
     * 
     * @param plugin
     * @param sender
     * @param command
     * @param commandLabel
     * @param args
     * 
     * @return Boolean
     */
    public abstract Boolean fromConsole(Plugin plugin, ConsoleCommandSender sender, Command command, String commandLabel, String[] args);
}