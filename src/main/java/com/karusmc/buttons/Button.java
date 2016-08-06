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
package com.karusmc.buttons;

import com.karusmc.controller.Controller;

import org.bukkit.Material;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public abstract class Button extends ItemStack {
    
    private Button() {}
    
    public Button(ItemStack itemstack) {
        super(itemstack);
    }
    
    public Button(Material type) {
        super(type);
    }
 
    
    public Button amount(int amount) {
        setAmount(amount);
        return this;
    }
    
    public Button durability(short durability) {
        setDurability(durability);
        return this;
    }
    
    
    public abstract void onClick(InventoryClickEvent event, Controller controller);
    
    public void onDrag(InventoryDragEvent event, Controller controller) {
        event.setCancelled(true);
    }
    
}
