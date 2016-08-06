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
package com.karusmc.controller;

import com.karusmc.menu.Menu;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.*;

import static com.karusmc.controller.ControllerUtility.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class SimpleController implements Controller {
    
    private Menu menu;
    
    
    private SimpleController() {}
    
    public SimpleController(Menu menu) {
        this.menu = menu;
    }
    
    
    @Override
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (menu.is(event.getInventory())) {
            handleButtonClick(event, this);
        }
    }
    
    
    @Override
    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        cancelEvent(event, this);
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    @Override
    public void setMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
