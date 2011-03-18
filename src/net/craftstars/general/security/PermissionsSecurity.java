package net.craftstars.general.security;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 * Security handler for use with Permissions plugin.
 * 
 * @author Plutonium239
 */
public class PermissionsSecurity implements SecurityImpl
{
    @Override
    public Boolean hasAccess(Player player, Command command)
    {
        return false;
    }
}