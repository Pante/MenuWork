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

import com.karusmc.buttons.mockbuttons.*;

import java.lang.reflect.Field;
import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class ButtonFactoryTest {
    
    private Map<String, Class<? extends Button>> buttons;
    
    private Button normal;
    
    private String shouldWork;
    private String shouldDefault;
    private String shouldFail;
    
    
    public ButtonFactoryTest() throws ReflectiveOperationException {
        
        Field field = ButtonFactory.class.getDeclaredField("BUTTONS");
        field.setAccessible(true);
        
        buttons = (Map<String, Class<? extends Button>>) field.get(null);
        
        normal = new NormalButton();
        
        shouldWork = "work";
        shouldDefault = "default";
        shouldFail = "fail";
        
    }
    
    
    @After
    public void clearMap() {
        buttons.clear();
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void register_ThrowsException() {
        ButtonFactory.register(shouldFail, InvalidButton.class);
    }
    
    @Test
    public void register_DoesNotPutButton() {
        try {
            ButtonFactory.register(shouldFail, InvalidButton.class);
        } catch (IllegalArgumentException e) {}
        
        assertTrue(buttons.isEmpty());
    }
    
    
    @Test
    public void register_RegistersButton() {
        ButtonFactory.register(shouldWork, NormalButton.class);
        
        assertEquals(NormalButton.class, buttons.get(shouldWork));
    }
    
    
    @Test
    public void create_ReturnsButton() {
        
        buttons.put(shouldWork, NormalButton.class);
        Button returned = ButtonFactory.create(shouldWork);
        
        assertEquals(NormalButton.class, returned.getClass());
        
    }
    
    @Test
    public void create_InvalidType_ReturnsDefaultButton() {
        
        buttons.put("", NormalButton.class);
        Button returned = ButtonFactory.create(shouldDefault);
        
        assertEquals(DefaultButton.class, returned.getClass());
        
    }
    
    @Test
    public void create_InvalidConstructor_ReturnsDefaultButton() {
        buttons.put(shouldDefault, InvalidButton.class);
        assertEquals(DefaultButton.class, ButtonFactory.create(shouldDefault).getClass());
    }
    
    
    @Test
    public void createOrDefault_ReturnsButton() {
        buttons.put(shouldWork, NormalButton.class);
        assertEquals(NormalButton.class, ButtonFactory.createOrDefault(shouldWork, null).getClass());
    }
    
    
    @Test
    public void createOrDefault_InvalidType_ReturnsDefaultButton() {
        buttons.put("", DefaultButton.class);
        assertEquals(NormalButton.class, ButtonFactory.createOrDefault(shouldDefault, normal).getClass());
    }
    
    @Test
    public void createOrDefault_InvalidConstructor_ReturnsDefaultButton() {
        buttons.put(shouldDefault, InvalidButton.class);
        assertEquals(NormalButton.class, ButtonFactory.createOrDefault(shouldDefault, normal).getClass());
    }
    
}
