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
package com.karusmc.menu;

import com.karusmc.buttons.mockobjects.MockMenu;
import org.bukkit.inventory.*;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class MenuTest {
    
    private DoubleChestInventory inventory;
    private Menu menu;
    
    
    public MenuTest() {
        inventory = mock(DoubleChestInventory.class);
        menu = new MockMenu(inventory);
    }
    
    @Test
    public void compare_returnsTrue() {
        assertTrue(menu.is(inventory));
    }
    
    @Test
    public void compare_returnsFalse() {
        assertFalse(menu.is(mock(DoubleChestInventory.class)));
    }
    
    
}
