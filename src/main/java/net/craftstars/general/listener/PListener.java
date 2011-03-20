package net.craftstars.general.listener;

import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerListener;

/**
 * This singleton responsible for listening for player events.
 * 
 * @author Plutonium239
 */
public class PListener extends PlayerListener
{
    private static final PListener INSTANCE = new PListener();
    
    private PListener() { }
    
    /**
     * Returns the instance of this class.
     * 
     * @return PListener the instance of this class
     */
    public static PListener getInstance()
    {
        return INSTANCE;
    }
    
    @Override
    public void onPlayerJoin(PlayerEvent event)
    {
        event.getPlayer().sendMessage("MOTD!");
    }
}