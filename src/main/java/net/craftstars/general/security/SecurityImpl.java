package net.craftstars.general.security;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 * The interface for Security modules.
 * 
 * @author Plutonium239
 */
public interface SecurityImpl
{
    /**
     * Returns whether or not Player has access to Command.
     * 
     * @param  player   the player to check access for
     * @param  command  the command to check access against
     * 
     * @return Boolean  True if the Player has access. False otherwise. 
     */
    public abstract Boolean hasAccess(Player player, Command command);
}