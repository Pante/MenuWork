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
import org.bukkit.inventory.Inventory;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public abstract class Menu implements Listener {
    
    protected Display display;
    protected Contents contents;
    
    
    private Menu() {}
    
    public Menu(Display display) {
        this.display = display;
        contents = new Contents();
    }
    
    public Menu(Display display, Contents contents) {
        this.display = display;
        this.contents = contents;
    }
    
    
    public abstract void onClick(InventoryClickEvent event);
    
    
    public void onDrag(InventoryDragEvent event) {}
    
    public void onClose(InventoryCloseEvent event) {}
    
    
    public void render() {
        display.render(contents);
    }
    
    public void renderButtons() {
        display.renderButtons(contents);
    }
    
    public void renderData() {
        display.renderData(contents);
    }
    
    public void display(Player player) {
        display.display(player);
    }
    
    public boolean is(Inventory inventory) {
        return display.is(inventory);
    }
    
    
    public Contents getContents() {
        return contents;
    }
    
    public void setContents(Contents contents) {
        this.contents = contents;
    }
    
}
