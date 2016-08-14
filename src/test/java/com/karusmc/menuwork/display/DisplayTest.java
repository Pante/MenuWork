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
    
    public static class MockDisplay extends Display<Inventory> {
    
        public MockDisplay(Inventory inventory) {
            super(inventory);
        }
    
    }
    
    
    private Display display;
    private Inventory inventory;
    private Player player;
    
    
    public DisplayTest() {
        
        inventory = mock(Inventory.class);
        when(inventory.getTitle()).thenReturn("Title");
        when(inventory.getSize()).thenReturn(25);
        
        player = mock(Player.class);
        
        display = new MockDisplay(inventory);
    }
    
    
    @Test
    public void display_callsOpenInventory() {
        display.display(player);
        
        verify(player, times(1)).openInventory(inventory);
    }
    
    
    @Test
    public void is_ReturnsTrue() {
        boolean returned = display.is(inventory);
        
        verify(inventory, times(2)).getTitle();
        verify(inventory, times(2)).getSize();
        
        assertTrue(returned);
    }
    
    @Test
    public void is_ReturnsFalse() {
        Inventory differentInventory = mock(Inventory.class);
        
        when(differentInventory.getTitle()).thenReturn("Title");
        when(differentInventory.getSize()).thenReturn(60);
        
        
        boolean returned = display.is(differentInventory);
        
        verify(differentInventory, times(1)).getTitle();
        verify(differentInventory, times(1)).getSize();
        
        assertFalse(returned);
    }
    
    
    @Test
    public void getItemAt_ReturnsItem() {
        ItemStack item = mock(ItemStack.class);
        when(inventory.getItem(25)).thenReturn(item);
        
        assertEquals(item, display.getItemAt(25));
    }
    
}
