package net.craftstars.general.util;

import java.util.List;


import org.bukkit.command.Command;
import org.bukkit.command.PluginCommandYamlParser;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Utility class with many useful tools.
 * 
 * @author Plutonium239
 */
public class Toolbox
{
    /**
     * Capitalizes the first letter of the string.
     * 
     * @param  str the string to capitalize
     * 
     * @return String
     */
    public static String capitalizeFirst(String str)
    {
        String mod = str.toLowerCase();
        mod = str.substring(0, 1).toUpperCase() + str.substring(1);
        
        return mod;
    }
    
    /**
     * Splits a string by "." and capitalizes each split.
     * <p>
     * Example: general.test becomes GeneralTest
     * Example: general.test.two becomes GeneralTestTwo
     * 
     * @param  str the string to convert to class name
     * 
     * @return String
     */
    public static String commandToClassName(String str)
    {
        String[] split = str.split("[.]");
        
        String out = "";
        
        for (String sp : split)
        {
            out += Toolbox.capitalizeFirst(sp);
        }
        
        return out;
    }
    
    /** 
     * This method iterates through all our defined commands and aliases
     * from plugin.yml and checks if they are bound to our plugin.
     * <p>
     * Currently this just logs a warning if it finds a problem, this may
     * be expanded or removed in the future.
     * 
     * @param plugin the plugin we're checking commands for
     */
    public static void verifyCommands(JavaPlugin plugin)
    {
        List<Command> commands = PluginCommandYamlParser.parse(plugin);
        String registeredPlugin;
        
        for (Command command : commands)
        {
            try
            {
                // CraftBukkit throws a NPE if we try this on a built-in command. That's not very nice. [Pu239]
                registeredPlugin = plugin.getServer().getPluginCommand(command.getName()).getPlugin().getDescription().getName();
            }
            catch (Exception ex)
            {
                registeredPlugin = "CraftBukkit";
            }
            
            if(!registeredPlugin.equals(plugin.getDescription().getName()))
            {
                Log.warn("Plugin ["+registeredPlugin+"] stole command ["+command.getName()+"] from us!");
            }
            
            List<String> commandAliases = command.getAliases();
            
            for (String commandName : commandAliases)
            {
                try
                {
                    // See above. [Pu239]
                    registeredPlugin = plugin.getServer().getPluginCommand(commandName).getPlugin().getDescription().getName();
                }
                catch (Exception ex)
                {
                    registeredPlugin = "CraftBukkit";
                }
                
                if(!registeredPlugin.equals(plugin.getDescription().getName()))
                {
                    Log.warn("Plugin ["+registeredPlugin+"] stole command ["+command.getName()+"] alias ["+commandName+"] from us!");
                }
            }
        }
    }
}