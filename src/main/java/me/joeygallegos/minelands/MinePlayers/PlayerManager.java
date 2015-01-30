package me.joeygallegos.minelands.MinePlayers;

import me.joeygallegos.minelands.Core;
import me.joeygallegos.minelands.Events.MinelandEvent;
import me.joeygallegos.minelands.Events.Players.FirstJoinEvent;
import me.joeygallegos.minelands.Exceptions.DataDownloadException;
import me.joeygallegos.minelands.Exceptions.DataNotFoundException;
import me.joeygallegos.minelands.Network.DB;
import me.joeygallegos.minelands.Ranks.Rank;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class PlayerManager extends MinelandEvent {

    public static Collection<MinePlayer> getOnlinePlayers() {
        return PlayerCache.getCache().values();
    }

    public static MinePlayer getPlayer(Player pl) {

        // IF CACHE HAS PLAYERS VALUE
        if (PlayerCache.getCache().containsKey(pl.getUniqueId())) {
            return PlayerCache.getCache().get(pl.getUniqueId());
        } else {

            // IF IT DOESN'T TRY DOWNLOADING IT
            try {
                return downloadPlayerData(pl);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            throw new DataNotFoundException("Player not in cache and couldn't be downloaded");
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static MinePlayer downloadPlayerData(Player player) throws SQLException{
        PreparedStatement stmt = DB.getConnection().prepareStatement("SELECT * FROM player_data WHERE uuid = ?;");
        stmt.setString(1, player.getUniqueId().toString());
        ResultSet set = stmt.executeQuery();

        // IF HAS
        if (set.next()) {
            long id = set.getLong("id");
            int rank = set.getInt("rankid");

            java.sql.Timestamp creationDate = set.getTimestamp("created_at");

            MinePlayer mp = new MinePlayer(player);
            mp.setId(id);
            mp.setJoinDate(creationDate);
            mp.setRawRankID(rank);
            mp.setRank(Rank.getById(rank));

            addToCache(mp);
            return mp;
        }
        set.close();
        return null;
    }

    /**
     * Adds a player to the Player Cache
     *
     * @param player Player to add to cache
     */
    private static void addToCache(MinePlayer player) {
        if (!contains(player)) {
            PlayerCache.getCache().put(player.getBukkitPlayer().getUniqueId(), player);
        }
    }

    /**
     * @param player Player to check
     * @return boolean If cache contains player
     */
    private static boolean contains(MinePlayer player) {
        return PlayerCache.getCache().containsValue(player);
    }


    /**
     * Removes a ClarityPlayer from the list
     *
     * @param player Player to remove
     */
    public static void trash(MinePlayer player) {
        if (contains(player)) {
            Core.getPlugin().getLogger().info(" ");
            Core.getPlugin().getLogger().info("Player is in PlayerManager list...");
            Core.getPlugin().getLogger().info("Attempting to trash...");

            try {
                Core.getPlugin().getLogger().info("Removed player with ID " + player.getUniqueId());
                PlayerCache.getCache().remove(player.getUniqueId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Core.getPlugin().getLogger().info(" ");
        }
    }

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
