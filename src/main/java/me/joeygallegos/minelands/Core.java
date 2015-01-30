package me.joeygallegos.minelands;

import me.joeygallegos.minelands.Commands.*;
import me.joeygallegos.minelands.Listeners.Test;
import me.joeygallegos.minelands.MinePlayers.Listeners.PlayerHandshakeListener;
import me.joeygallegos.minelands.MinePlayers.PlayerManager;
import me.joeygallegos.minelands.Network.DB;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class Core extends JavaPlugin {

    private static final boolean production = false;
    private static Core plugin;

    public static Core getPlugin() {
        return plugin;
    }

    public static boolean isProduction() {
        return production;
    }

    @Override
    public void onEnable() {

        if (isProduction()) {
            getLogger().info("You chat ");
        }

        // SETUP CONNECTION
        try {
            DB.setupConnection();
            getLogger().info("*** CONNECTION TO NETWORK MADE ***");
        } catch (SQLException e) {
            getLogger().warning("*** ERROR CONNECTING ***");
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);
        }

        plugin = this;

        // PLAYER MANAGER
        registerEvents(this, new Test(), new PlayerManager(), new PlayerHandshakeListener());

        // CUSTOM COMMANDS
        try {
            CommandManager.registerCommand(this, new Heal());
            CommandManager.registerCommand(this, new WhoIs());
            CommandManager.registerCommand(this, new TP());
        } catch (CustomCommandException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        plugin = null;
    }

    private void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            getServer().getPluginManager()
                    .registerEvents(listener, plugin);
        }
    }
}
