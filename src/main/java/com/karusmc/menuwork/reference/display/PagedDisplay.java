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
package com.karusmc.menuwork.reference.display;

import com.karusmc.menuwork.display.*;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class PagedDisplay extends Display<Inventory> {

    public PagedDisplay(int size, String title) {
        super(Bukkit.createInventory(null, size, title));
    }
    
    protected PagedDisplay(Inventory inventory) {
        super(inventory);
    }
    

    @Override
    public void renderButtons(Contents contents) {
        int lastRow = inventory.getSize() - 10;
        
        inventory.setItem(lastRow, contents.getButtons().get("Back"));
        inventory.setItem(inventory.getSize() - 1, contents.getButtons().get("Next"));
    }

    @Override
    public void renderData(Contents contents) {
        int renderSpace = inventory.getSize() - 10;
        int i = 0;
        
        for(ItemStack item : contents.getData()) {
            if (i >= renderSpace) {
                break;
            }
            
            inventory.setItem(i, item);
        }
    }
    
}
