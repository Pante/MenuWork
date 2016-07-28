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

import com.karusmc.menuwork.controller.EventListener;

import org.bukkit.inventory.Inventory;

/**
 *
 * @author PanteLegacy @ karusmc.com
 * @param <Display>
 */

public abstract class Menu<Display extends Inventory> {
    
    protected Display inventory;
    protected Contents contents;
    protected EventListener listener;
    
    private Menu() {}
    
    public Menu(Display inventory, Contents contents, EventListener listener) {
        this.inventory = inventory;
        this.contents = contents;
        this.listener = listener;
    }
    
    
    public void render() {
        renderData();
        renderButtons();
    }
    
    public abstract void renderData();
    
    public abstract void renderButtons();
    
    
    public Contents getContents() {
        return contents;
    }
    
    public void setContents(Contents contents) {
        this.contents = contents;
    }
    
}
