/*
 * This file is part of General.
 *
 * General is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * General is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with General.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.craftstars.general;

import net.craftstars.general.command.AbstractCommand;
import net.craftstars.general.listener.PListener;
import net.craftstars.general.listener.SListener;
import net.craftstars.general.util.Log;
import net.craftstars.general.util.Toolbox;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * General Plug-in for CraftBukkit.
 * 
 * @author Plutonium239
 */
public final class General extends JavaPlugin
{
    /**
     * Defines if we are running in debug mode.
     */
    public final static Boolean DEBUG_MODE = true;
    
    /**
     * Implemented in CraftBukkit #553.
     * <p>
     * Currently this is called when "reload" is issued. 
     * I'm assuming it's NOT called when a plugin is 
     * simply disabled/enabled. Which means we should
     * do all out resource allocation here. [Pu239]
     */
    @Override
    public void onLoad()
    {
        // Initialize our logger.
        Log.initialize(this.getServer().getLogger(), this.getDescription().getName(), DEBUG_MODE);
    }
    
    @Override
    public void onEnable()
    {   
        // Register our events
        this.registerEvents();
        
        // Initialize server stats
        this.initStats();
        
        // Verify we got all our commands
        Toolbox.verifyCommands(this);
        
        Log.info("Plugin Enabled!");
    }
    
    @Override
    public void onDisable()
    {
        Log.info("Plugin Disabled!");
    }
    
    private void registerEvents()
    {
        // PlayerListener events.
        this.getServer().getPluginManager().registerEvent(Event.Type.PLAYER_JOIN, PListener.getInstance(), Event.Priority.Normal, this);
        
        // ServerListener events.
        this.getServer().getPluginManager().registerEvent(Event.Type.PLUGIN_ENABLE, SListener.getInstance(), Event.Priority.Normal, this);
        this.getServer().getPluginManager().registerEvent(Event.Type.PLUGIN_DISABLE, SListener.getInstance(), Event.Priority.Normal, this);
    }
    
    /**
     * Not used... yet.
     */
    private void initStats()
    {
        //this.getServer().getScheduler().scheduleAsyncRepeatingTask(this, this.statsRunnable, 200L, 6000L);
        //Log.info("Stats scheduled!");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
    {
        try
        {
            Class<? extends AbstractCommand> clazz = this.getClass().getClassLoader().loadClass("net.craftstars.general.command." + Toolbox.commandToClassName(commandLabel) + "Command").asSubclass(AbstractCommand.class);
            AbstractCommand commandInstance = (AbstractCommand) clazz.newInstance();
            
            return commandInstance.executeCommand(this, sender, command, commandLabel, args);
        }
        catch (Exception ex)
        {
            Log.error("There was a big problem executing the command ["+command.getName()+"].");
        }
        
        // If we get here, assume the command failed for whatever reason.
        return false;
    }
}