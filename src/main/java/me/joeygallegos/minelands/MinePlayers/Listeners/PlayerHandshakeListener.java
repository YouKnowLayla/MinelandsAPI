package me.joeygallegos.minelands.MinePlayers.Listeners;

import me.joeygallegos.minelands.Core;
import me.joeygallegos.minelands.Events.MinelandEvent;
import me.joeygallegos.minelands.Events.Players.FirstJoinEvent;
import me.joeygallegos.minelands.MinePlayers.MinePlayer;
import me.joeygallegos.minelands.MinePlayers.PlayerManager;
import me.joeygallegos.minelands.Network.DB;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class PlayerHandshakeListener extends MinelandEvent {

    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent event) {
        if (!playerDataExists(event.getPlayer())) {
            boolean containsPlayer = false;
            String text = containsPlayer ? "'s data does exist" : "'s data doesn't exist";
            Core.getPlugin().getLogger().info(event.getPlayer().getName() + text);

            try {
                createPlayerAccount(event.getPlayer());
                MinePlayer pl = PlayerManager.getPlayer(event.getPlayer());
                Core.getPlugin().getLogger().info(pl.getName() + "'s account was created");

                // CALL EVENT
                Bukkit.getPluginManager().callEvent(new FirstJoinEvent(event.getPlayer(), pl));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @EventHandler
    public void onFirstJoinEvent(FirstJoinEvent event) {

        // FIRST JOIN EVENT
        MinePlayer player = event.getMinePlayer();
        player.message("§dThank you for joining the server for the first time");
    }

    // --------
    // METHODS
    // --------
    private void createPlayerAccount(Player player) throws SQLException {

        PreparedStatement stmt = DB.getConnection().prepareStatement("INSERT INTO player_data (uuid, created_at) VALUES (?, ?);");

        stmt.setString(1, player.getUniqueId().toString());

        java.util.Date date = new java.util.Date();
        stmt.setTimestamp(2, new Timestamp(date.getTime()));

        stmt.executeUpdate();
        stmt.close();
    }

    private boolean playerDataExists(Player player) {
        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement("SELECT * FROM player_data WHERE uuid = ?");
            stmt.setString(1, player.getUniqueId().toString());
            ResultSet rs = stmt.executeQuery();

            boolean containsPlayer = rs.next();
            stmt.close();
            rs.close();

            return containsPlayer;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
