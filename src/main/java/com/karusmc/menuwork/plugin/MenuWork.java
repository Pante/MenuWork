/*
 * Copyright (C) 2016 PanteLegacy @ karusmc.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.karusmc.menuwork.plugin;

import com.karusmc.menuwork.menu.*;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class MenuWork extends JavaPlugin implements TabExecutor{
    
    private Menu aboutMenu;
    
    @Override
    public void onEnable() {
        aboutMenu = new SimpleMenu(new AboutDisplay("About MenuWork"));
        aboutMenu.getContents().getButtons().put("About", new AboutButton(Material.ANVIL, getDescription()));
        
        Bukkit.getPluginManager().registerEvents(aboutMenu, this);
        getCommand("MenuWork").setExecutor(this);
    }
    
    @Override
    public void onDisable() {
        HandlerList.unregisterAll(aboutMenu);
    }
    
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            aboutMenu.display((Player) sender);
        }
        
        return true;
    }
    
}
