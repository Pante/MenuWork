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

import com.karusmc.buttons.mockobjects.InvalidButton;
import com.karusmc.buttons.mockobjects.NormalButton;

import java.lang.reflect.Field;
import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class ButtonFactoryTest {

    private static final String WILL_WORK= "Work";
    private static final String WILL_DEFAULT = "default";
    private static final String WILL_FAIL = "fail";
    
    
    private Map<String, Class<? extends Button>> buttons;
    
    private Button normal;
    
    
    public ButtonFactoryTest() throws ReflectiveOperationException {
        
        Field field = ButtonFactory.class.getDeclaredField("BUTTONS");
        field.setAccessible(true);
        
        buttons = (Map<String, Class<? extends Button>>) field.get(null);
        
        normal = new NormalButton();
    }
    
    
    @Before
    public void clearMap() {
        buttons.clear();
    }
    
    
    @Test
    public void register_ThrowsException_DoesNotPutButton() {
        try {
            ButtonFactory.register(WILL_FAIL, InvalidButton.class);
        } catch (IllegalArgumentException e) {
            assertTrue(buttons.isEmpty());
            return;
        }
        
        throw new RuntimeException();
    }
    
    
    @Test
    public void register_RegistersButton() {
        ButtonFactory.register(WILL_WORK, NormalButton.class);
        assertEquals(NormalButton.class, buttons.get(WILL_WORK));
    }
    
    
    @Test
    public void create_ReturnsButton() {
        buttons.put(WILL_WORK, NormalButton.class);
        assertEquals(NormalButton.class, ButtonFactory.create(WILL_WORK).getClass());
    }
    
    @Test
    public void create_InvalidType_ReturnsDefaultButton() {
        assertEquals(DefaultButton.class, ButtonFactory.create(WILL_DEFAULT).getClass());
    }
    
    @Test
    public void create_InvalidConstructor_ReturnsDefaultButton() {
        buttons.put(WILL_DEFAULT, InvalidButton.class);
        assertEquals(DefaultButton.class, ButtonFactory.create(WILL_DEFAULT).getClass());
    }
    
    
    @Test
    public void createOrDefault_ReturnsButton() {
        buttons.put(WILL_WORK, NormalButton.class);
        assertEquals(NormalButton.class, ButtonFactory.createOrDefault(WILL_WORK, null).getClass());
    }
    
    
    @Test
    public void createOrDefault_InvalidType_ReturnsDefaultButton() {
        assertEquals(NormalButton.class, ButtonFactory.createOrDefault(WILL_DEFAULT, normal).getClass());
    }
    
    @Test
    public void createOrDefault_InvalidConstructor_ReturnsDefaultButton() {
        buttons.put(WILL_DEFAULT, InvalidButton.class);
        assertEquals(NormalButton.class, ButtonFactory.createOrDefault(WILL_DEFAULT, normal).getClass());
    }
    
}
