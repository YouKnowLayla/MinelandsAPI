package me.joeygallegos.minelands.Events;

import me.joeygallegos.minelands.Core;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public abstract class MinelandEvent implements Listener {

    public MinelandEvent() {
        Bukkit.getPluginManager().registerEvents(this, Core.getPlugin());
    }
}
