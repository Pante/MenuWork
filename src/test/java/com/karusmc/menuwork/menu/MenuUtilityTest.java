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

import com.karusmc.menuwork.buttons.Button;

import org.bukkit.event.inventory.*;
import org.bukkit.inventory.*;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class MenuUtilityTest {
    
    private InventoryClickEvent clickEvent;
    private InventoryDragEvent dragEvent;
    private Menu menu;
    private Inventory inventory;
    private Button button;
    
    
    public MenuUtilityTest() {
        clickEvent = mock(InventoryClickEvent.class);
        dragEvent = mock(InventoryDragEvent.class);
        menu = mock(Menu.class);
        inventory = mock(Inventory.class);
        button = mock(Button.class);
        
        when(dragEvent.getInventory()).thenReturn(inventory);
        when(menu.is(inventory)).thenReturn(true);
    }
    
    
    @Test
    public void cancelEvent_CallsCancel() {
        when(menu.is(inventory)).thenReturn(true);
        
        MenuUtility.cancelEvent(dragEvent, menu);
        verify(dragEvent, times(1)).setCancelled(true);
    }
    
    @Test
    public void cancelEvent_DoestNotCallsCancel() {
        when(menu.is(inventory)).thenReturn(false);
        
        MenuUtility.cancelEvent(dragEvent, menu);
        verify(dragEvent, times(0)).setCancelled(false);
    }
    
    
    @Test
    public void handleButtonClick_CallsOnClick() {
        when(clickEvent.getCurrentItem()).thenReturn(button);
        
        boolean returned = MenuUtility.handleButtonClick(clickEvent, menu);
        
        verify(button, times(1)).onClick(clickEvent, menu);
        assertTrue(returned);
    }
    
    @Test
    public void handleButtonClick_DoestNotCallOnClick() {
        when(clickEvent.getCurrentItem()).thenReturn(new ItemStack(0));
        
        boolean returned = MenuUtility.handleButtonClick(clickEvent, menu);
        
        verify(button, times(0)).onClick(clickEvent, menu);
        assertFalse(returned);
    }
    
    
    @Test
    public void handleButtonDrag_CallsOnDrag() {
        when(dragEvent.getCursor()).thenReturn(button);
        
        boolean returned = MenuUtility.handleButtonDrag(dragEvent, menu);
        
        verify(button, times(1)).onDrag(dragEvent, menu);
        assertTrue(returned);
    }
    
    @Test
    public void handleButtonDrag_DoestNotCallOnDrag() {
        when(dragEvent.getCursor()).thenReturn(new ItemStack(0));
        
        boolean returned = MenuUtility.handleButtonDrag(dragEvent, menu);
        
        verify(button, times(0)).onDrag(dragEvent, menu);
        assertFalse(returned);
    }
    
}
