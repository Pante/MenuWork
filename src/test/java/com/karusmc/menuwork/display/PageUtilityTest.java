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

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class PageUtilityTest {
    
    @Test
    public void calculatePageSize_ReturnsNumber() {
        int returned = PageUtility.calculatePageSize(10, 50);
        assertEquals(9, returned);
    }
    
    @Test
    public void calculatePageSize_Returns54() {
        int returned = PageUtility.calculatePageSize(500, 1);
        assertEquals(54, returned);
    }
    
    
    @Test
    public void calculateTotalPages_ReturnsNumber() {
        int returned = PageUtility.calculateTotalPages(10, 100);
        assertEquals(1, returned);
    }
    
    
    @Test
    public void getFirstItemOnPageIndex_ReturnsNumber() {
        int returned = PageUtility.getFirstItemOnPageIndex(3, 50);
        assertEquals(100, returned);
    }
    
    @Test
    public void getLastItemOnPageIndex_ReturnsNumber() {
        int returned = PageUtility.getLastItemOnPageIndex(100, 2, 25);
        assertEquals(50, returned);
    }
    
}
