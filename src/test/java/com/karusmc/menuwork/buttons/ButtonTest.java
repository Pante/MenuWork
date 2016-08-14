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
package com.karusmc.menuwork.buttons;

import org.bukkit.event.inventory.InventoryDragEvent;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class ButtonTest {
    
    private Button button;
    private InventoryDragEvent event;
    
    public ButtonTest() {
        event = mock(InventoryDragEvent.class);
        button = mock(Button.class, Mockito.CALLS_REAL_METHODS);
    }
    
    
    @Test
    public void onDrag_cancelsEvent() {
        button.onDrag(event, null);
        
        verify(event, times(1)).setCancelled(true);
    }
    
}
