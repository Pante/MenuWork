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

import org.bukkit.event.inventory.*;
import org.bukkit.inventory.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class Template {
    
    private InventoryType type;
    private Map<Integer, ItemStack> items;
    
    
    private Template() {}
    
    public Template(InventoryType type, Map<Integer, ItemStack> items) {
        this.type = type;
        this.items = items;
    }
    
    
    public boolean isCompatible(Inventory inventory) {
        return type == inventory.getType() && Collections.max(items.keySet()) <= inventory.getSize();
    }
    
    public void apply(Inventory inventory) {
        items.forEach((slot, item) -> inventory.setItem(slot, item));
    }
    
}
