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

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class General extends JavaPlugin
{
	public static Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable()
	{
		logger.info("[General] Plugin Enabled!");
	}
	
	@Override
	public void onDisable()
	{
		logger.info("[General] Plugin Enabled!");
	}
}