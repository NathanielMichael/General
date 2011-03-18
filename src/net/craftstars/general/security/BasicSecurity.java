package net.craftstars.general.security;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 * BasicSecurity is the fall back security class if no others are found.
 * 
 * @author Plutonium239
 */
public class BasicSecurity implements SecurityImpl
{
    @Override
    public Boolean hasAccess(Player player, Command command)
    {
        return player.isOp();
    }   
}