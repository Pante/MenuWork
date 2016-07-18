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
package com.karusmc.menuwork.controller;

import com.karusmc.menuwork.contents.Contents;
import com.karusmc.menuwork.menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class SimpleController implements EventListener {
    
    private Menu menu;
    private Contents contents;
    
    
    @Override
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();
        
        if (item instanceof Button) {
            ((Button) item).onClick(event.getInventory(), player);
        }
        
        event.setCancelled(true);
    }

    @Override
    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        event.setCancelled(true);
    }

    @Override
    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        
    }
    
}
