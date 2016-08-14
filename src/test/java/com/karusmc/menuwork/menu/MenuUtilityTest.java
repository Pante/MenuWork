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
import com.karusmc.menuwork.display.Display;

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
    
    private Menu menu;
    private Display display;
    
    private Inventory inventory;
    private Button button;
    
    
    public MenuUtilityTest() {
        clickEvent = mock(InventoryClickEvent.class);
        
        menu = mock(Menu.class);
        display = mock(Display.class);
        
        inventory = mock(Inventory.class);
        button = mock(Button.class);
        
        
        when(clickEvent.getInventory()).thenReturn(inventory);
        
        when(menu.getDisplay()).thenReturn(display);
        when(menu.getDisplay().is(inventory)).thenReturn(true);
        
    }
    
    
    @Test
    public void cancelEvent_CallsCancel() { 
        MenuUtility.cancelEvent(clickEvent, menu);
        
        verify(clickEvent, times(1)).setCancelled(true);
    }
    
    @Test
    public void cancelEvent_DoestNotCallsCancel() {
        when(menu.getDisplay().is(inventory)).thenReturn(false);
        
        MenuUtility.cancelEvent(clickEvent, menu);
        
        verify(clickEvent, times(0)).setCancelled(false);
    }
    
    
    //@Test
    public void handleButtonClick_CallsOnClick() {
        when(clickEvent.getCurrentItem()).thenReturn(button);
        
        boolean returned = MenuUtility.handleButtonClick(clickEvent, menu);
        
        verify(button, times(1)).onClick(clickEvent, menu);
        assertTrue(returned);
    }
    
    //@Test
    public void handleButtonClick_DoestNotCallOnClick() {
        when(clickEvent.getCurrentItem()).thenReturn(new ItemStack(0));
        
        boolean returned = MenuUtility.handleButtonClick(clickEvent, menu);
        
        verify(button, times(0)).onClick(clickEvent, menu);
        assertFalse(returned);
    }
    
}
