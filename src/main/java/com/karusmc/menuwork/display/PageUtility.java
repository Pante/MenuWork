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

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class PageUtility {
    
    private PageUtility() {}
    
    
    public static int calculatePageSize(int total, int numberOfPages) {
        
        double rawNumberOfSlots = (double) total / numberOfPages;
        int roundedNumberOfSlots = (int) (Math.ceil(rawNumberOfSlots / 9.0) * 9.0);
        
        return Math.min(roundedNumberOfSlots, 54);
    }
    
    public static int calculateTotalPages(int total, int renderSpace) {
        return (int) Math.ceil((double) total / renderSpace);
    }
    
    
    public static int getFirstItemOnPageIndex(int page, int renderSize) {
        return (page * renderSize) - renderSize;
    }
    
    public static int getLastItemOnPageIndex(int total, int page, int renderSize) {
        return Math.min(total, page * renderSize);   
    }
    
}
