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
package com.karusmc.menuwork.plugin;

import com.karusmc.menuwork.buttons.Button;
import com.karusmc.menuwork.menu.Menu;

import org.bukkit.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.PluginDescriptionFile;

/**
 *
 * @author PanteLegacy @ karusmc.com
 */
public class AboutButton extends Button {
    
    private PluginDescriptionFile file;
    private String information;
    
    
    public AboutButton(Material type, PluginDescriptionFile file) {
        super(type);
        formatInfo(file);
    }
    
    
    private void formatInfo(PluginDescriptionFile description) {
        StringBuilder buffy = new StringBuilder();
        buffy.append("&6").append(description.getName()).append(" version: &c").append(description.getVersion()).append("\n&6");
        buffy.append(description.getDescription());
        buffy.append("\nAuthor(s): &c").append(description.getAuthors().toString());
        buffy.append("\n&6Source code & development resources: &c").append(description.getWebsite());

        information = ChatColor.translateAlternateColorCodes('&', buffy.toString());
    }
        

    @Override
    public void onClick(InventoryClickEvent event, Menu menu) {
        event.getWhoClicked().sendMessage(information);
    }
    
}
