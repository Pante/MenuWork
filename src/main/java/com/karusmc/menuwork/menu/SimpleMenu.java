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
import static com.karusmc.menuwork.menu.MenuUtility.handleButtonClick;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class SimpleMenu implements Menu {
    
    private Display display;
    
    
    private SimpleMenu() {}
    
    public SimpleMenu(Display menu) {
        this.display = menu;
    }
    
    
    @Override
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        handleButtonClick(event, this);
    }

    
    @Override
    public Display getDisplay() {
        return display;
    }

    @Override
    public void setDisplay(Display display) {
        this.display = display;
    }

    
    @Override
    public Contents getContents() {
        return display.getContents();
    }

    @Override
    public void render() {
        display.render();
    }

    @Override
    public void renderData() {
        display.renderData();
    }

    @Override
    public void renderButtons() {
        display.renderButtons();
    }

    @Override
    public void display(Player player) {
        display.display(player);
    }
    
}
