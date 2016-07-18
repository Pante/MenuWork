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
package com.karusmc.menuwork.contents;

import com.karusmc.menuwork.controller.Button;
import java.util.*;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class Contents {
    
    private List<ItemStack> data;
    private Map<String, Button> buttons;
    
    
    private Contents() {}
    
    public Contents(List<ItemStack> data, Map<String, Button> buttons) {
        this.data = data;
        this.buttons = buttons;
    }
    
    
    public List<ItemStack> getData() {
        return data;
    }
    
    public Map<String, Button> getButtons() {
        return buttons;
    }
    
}
