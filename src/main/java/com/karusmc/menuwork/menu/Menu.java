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

import com.karusmc.menuwork.display.*;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public interface Menu extends Listener {
    
    public void onClick(InventoryClickEvent event);
    
    
    public default void onDrag(InventoryDragEvent event) {}
    
    public default void onClose(InventoryCloseEvent event) {}
    
    
    public Display getDisplay();
    
    public void setDisplay(Display display);
    
    
    public Contents getContents();
    
    
    public void render();
    
    public void renderData();
    
    public void renderButtons();
    
    public void display(Player player);
    
}
