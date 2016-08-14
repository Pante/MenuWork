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
package com.karusmc.menuwork.menu;

import java.util.*;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class MenuManager {
    
    private static final Map<String, Menu> MENUS = new HashMap<>();
    
    public static JavaPlugin plugin;
    
    
    private MenuManager() {}
    
    
    public static Map<String, Menu> getMenus() {
        return MENUS;
    }
    
    
    public static void registerMenu(String key, Menu menu) {
        Bukkit.getPluginManager().registerEvents(menu, plugin);
        MENUS.put(key, menu);
    }
    
    public static void unregisterMenu(String key) {
        Menu menu = MENUS.get(key);
        MENUS.remove(key);
        
        HandlerList.unregisterAll(menu);
    }
    
    
    public static Menu get(String key) {
        return MENUS.get(key);
    }
    
    public static Menu getOrDefault(String key, Menu defaultMenu) {
        return MENUS.getOrDefault(key, defaultMenu);
    }
    
    
}
