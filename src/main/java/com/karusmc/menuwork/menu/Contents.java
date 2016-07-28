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

import com.karusmc.menuwork.button.Button;
import java.util.*;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class Contents {
    
    private Map<String, Button> buttons;
    private List<ItemStack> items;
    
    
    public Map<String, Button> getButtons() {
        return buttons;
    }
    
    public void setButtons(Map<String, Button> buttons) {
        this.buttons = buttons;
    }
    
    
    public List<ItemStack> getItems() {
        return items;
    }
    
    public void setItems(List<ItemStack> items) {
        this.items = items;
    }
    
}
