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
package com.karusmc.buttons;

import java.util.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class ButtonFactory {
    
    private static final Map<String, Class<? extends Button>> BUTTONS = new HashMap<>();
    private static DefaultButton defaultButton = new DefaultButton();
    
    
    private ButtonFactory() {}
    
    
    public static void register(String type, Class<? extends Button> button) {
        try {
            
            button.getConstructor().newInstance();
            BUTTONS.putIfAbsent(type, button);
            
        } catch(ReflectiveOperationException e) {
            throw new IllegalArgumentException(e);
        } 
        
    }
    
    public static void unregister(String type) {
        BUTTONS.remove(type);
    }
    
    
    public static Button create(String type) {
        return createOrDefault(type, defaultButton.createNewInstance());
    }
    
    public static Button createOrDefault(String type, Button button) {
        try {
            return BUTTONS.get(type).getConstructor().newInstance();
            
        } catch (ReflectiveOperationException | NullPointerException e) {
            return button;
        }
    }
    
    
    public static DefaultButton getDefaultButton() {
        return defaultButton;
    }
    
    public static void setDefaultButton(DefaultButton button) {
        defaultButton = button;
    }
    
}
