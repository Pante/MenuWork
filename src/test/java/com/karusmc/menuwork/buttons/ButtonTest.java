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

import com.karusmc.menuwork.mock.MockButton;

import org.bukkit.event.inventory.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class ButtonTest {
    
    private Button button;
    private InventoryDragEvent event;
    
    public ButtonTest() {
        button = new MockButton();
        event = mock(InventoryDragEvent.class);
    }
    
    @Test
    public void testAmount_SetsAmount() {
        button.amount(100);
        assertEquals(100, button.getAmount());
    }
    
    @Test
    public void testDurability_SetsDurability() {
        button.durability((short) 8);
        assertEquals(8, button.getDurability());
    }
    
    
    @Test
    public void onDrag_callsCancel() {
        button.onDrag(event, null);
        verify(event, times(1)).setCancelled(true);
    }
    
}
