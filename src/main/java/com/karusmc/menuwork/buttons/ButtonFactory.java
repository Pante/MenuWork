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

import java.util.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class ButtonFactory {
    
    private static final Map<String, Class<? extends Button>> BUTTONS = new HashMap<>();
    private static Button defaultButton = new DefaultButton();
    
    
    public static void register(String type, Class<? extends Button> button) {
        BUTTONS.putIfAbsent(type, button);
    }
    
    public static void unregister(String type) {
        BUTTONS.remove(type);
    }
    
    
    public static Button createOrDefault(String type, Button defaultButton) {
        try {
            return BUTTONS.get(type).getConstructor().newInstance();
            
        } catch (ReflectiveOperationException | NullPointerException e) {
            return defaultButton;
        }
    }
    
    public static Button create(String type) {
        return createOrDefault(type, defaultButton);
    }
    
    
    public static Button getDefaultButton() {
        return defaultButton;
    }
    
    public static void setDefaultButton(Button defaultButton) {
        ButtonFactory.defaultButton = defaultButton;
    }
    
}
