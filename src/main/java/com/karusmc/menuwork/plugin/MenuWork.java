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
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class MenuWork extends JavaPlugin implements TabExecutor{
    
    
    public static MenuWork instance;
    
    @Override
    public void onEnable() {
        
        instance = this;
        MenuManager.plugin = this;
        
        Menu aboutMenu = new SimpleMenu(new AboutDisplay("About MenuWork"));
        aboutMenu.getContents().getButtons().put("About", new AboutButton(Material.ANVIL, getDescription()));
        aboutMenu.render();
        
        MenuManager.registerMenu("About", aboutMenu);
    }
    
    
    @Override
    public void onDisable() {
        MenuManager.unregisterMenu("About");
    }
    
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            MenuManager.get("About").display((Player) sender);
        }
        
        return true;
    }
    
}
