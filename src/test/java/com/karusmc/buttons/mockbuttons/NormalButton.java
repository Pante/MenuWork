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
package com.karusmc.buttons.mockbuttons;

import com.karusmc.buttons.Button;
import com.karusmc.menu.Menu;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class NormalButton extends Button {

    public NormalButton() {
        super(Material.ANVIL);
    }

    @Override
    public void onClick(InventoryClickEvent event, Menu menu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
