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

import com.karusmc.buttons.Button;
import com.karusmc.menu.Menu;

import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;

import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class ControllerUtilityTest {
    
    private Menu menu;
    private InventoryClickEvent event;
    private Button button;
    
    public ControllerUtilityTest() {
        menu = mock(Menu.class);
        event = mock(InventoryClickEvent.class);
        button = mock(Button.class);
    }
    
    
    @Test
    public void cancelEvent_callsEventSetCancelled() {
        when(menu.is(event.getInventory())).thenReturn(true);
        
        ControllerUtility.cancelEvent(event, menu);
        
        verify(event, times(1)).setCancelled(true);
    }
    
    @Test
    public void cancelEvent_doesNotCallEventSetCancelled() {
        when(menu.is(event.getInventory())).thenReturn(false);
        
        ControllerUtility.cancelEvent(event, menu);
        
        verify(event, times(0)).setCancelled(true);
    }
    
    
    @Test
    public void handleButtonClick_callsOnClick_ReturnsTrue() {
        when(event.getCurrentItem()).thenReturn(button);
        
        boolean returned = ControllerUtility.handleButtonClick(event, menu);
        
        verify(button, times(1)).onClick(event, menu);
        
        assertTrue(returned);
    }
    
    @Test
    public void handleButtonClick_doestNotCallOnClick_ReturnsFalse() {
        ItemStack item = mock(ItemStack.class);
        when(event.getCurrentItem()).thenReturn(item);
        
        boolean returned = ControllerUtility.handleButtonClick(event, menu);
        
        assertFalse(returned);
    }
    
}
