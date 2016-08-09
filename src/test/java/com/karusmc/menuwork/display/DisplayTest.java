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
package com.karusmc.menuwork.display;

import com.karusmc.menuwork.mock.MockDisplay;

import org.bukkit.entity.Player;
import org.bukkit.inventory.*;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class DisplayTest {
    
    private MockDisplay display;
    private DoubleChestInventory inventory;
    
    
    public DisplayTest() {
        inventory = mock(DoubleChestInventory.class);
        display = new MockDisplay(inventory);
    }
    
    
    @Test
    public void is_ReturnsTrue() {
        boolean returned = display.is(inventory);
        assertTrue(returned);
    }
    
    @Test
    public void is_NewInstance_ReturnFalse() {
        boolean returned = display.is(mock(DoubleChestInventory.class));
        assertFalse(returned);
    }
    
    @Test
    public void is_AnotherType_ReturnsFalse() {
        boolean returned = display.is(mock(Inventory.class));
        assertFalse(returned);
    }
    
    
    @Test
    public void display_callsOpenInventory() {
        Player player = mock(Player.class);
        display.display(player);
        verify(player, times(1)).openInventory(inventory);
    }
    
}
