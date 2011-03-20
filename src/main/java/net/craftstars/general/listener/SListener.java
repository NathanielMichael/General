package net.craftstars.general.listener;

import org.bukkit.event.server.PluginEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.server.ServerListener;

/**
 * The singleton responsible for listening to server events.
 * 
 * @author Plutonium239
 */
public class SListener extends ServerListener
{
    private static final SListener INSTANCE = new SListener();
    
    private SListener() { }
    
    /**
     * Returns the instance of this class.
     * 
     * @return SListener the instance of this class
     */
    public static SListener getInstance()
    {
        return INSTANCE;
    }
    
    public void onPluginEnabled(PluginEvent event)
    {
        /*
         * Ninjikokun told me this was fixed but it still appears
         * to be broken. (As of build #539)
         * 
         * When a plugin is loaded BEFORE this one, this event
         * is NOT triggered.
         * 
         * It seems like a BAD IDEA to rely on this for any
         * reason.
         * 
         * -Plutonium239
         */
    }
    
    public void onPluginDisabled(PluginEvent event)
    {
        // See above.
    }
    
    public void onServerCommand(ServerCommandEvent event)
    {
        // Nothing here yet.
    }
}