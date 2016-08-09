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
package com.karusmc.menuwork.reference.buttons;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class TeleportButtonTest {
    
    private TeleportButton button;
    private Location location;
    private InventoryClickEvent event;
    private Player player;
    
    
    public TeleportButtonTest() {
        location = mock(Location.class);
        button = new TeleportButton(Material.THIN_GLASS, location);
        
        event = mock(InventoryClickEvent.class);
        player = mock(Player.class);
    }
    
    
    @Test
    public void onClick_TeleportsPlayer() {
        when(event.getWhoClicked()).thenReturn(player);
        button.onClick(event, null);
        
        verify(player, times(1)).teleport(location);
    }
    
}
