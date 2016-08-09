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

import com.karusmc.menuwork.display.*;
import org.bukkit.Bukkit;

import org.bukkit.inventory.Inventory;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class AboutDisplay extends Display<Inventory> {
    
    public AboutDisplay(String title) {
        super(Bukkit.createInventory(null, 54, title));
    }
    
    protected AboutDisplay(Inventory inventory) {
        super(inventory);
    }

    
    @Override
    public void renderButtons(Contents contents) {
        inventory.setItem(4, contents.getButtons().get("About"));
    }
    
}
