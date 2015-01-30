package me.joeygallegos.minelands.MinePlayers;

import me.joeygallegos.minelands.MinePlayers.Bans.BanModule;
import me.joeygallegos.minelands.Ranks.Rank;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class MinePlayer {

    protected String name, displayName, playerListName;
    protected UUID uniqueId;

    private long id;
    private Rank rank;
    private int rawRankID;

    private Timestamp joinDate;

    private long credits, coins;

    private BanModule banModule= null;
    private boolean banned;

    public MinePlayer(Player player) {

        this.name = player.getName();
        this.displayName = player.getDisplayName();
        this.playerListName = player.getPlayerListName();

        this.uniqueId = player.getUniqueId();
    }

    public Player getBukkitPlayer() {
        return Bukkit.getPlayer(this.uniqueId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPlayerListName() {
        return playerListName;
    }

    public void setPlayerListName(String playerListName) {
        this.playerListName = playerListName;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getRawRankID() {
        return rawRankID;
    }

    public void setRawRankID(int rawRankID) {
        this.rawRankID = rawRankID;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    public long getCredits() {
        return credits;
    }

    public void setCredits(long credits) {
        this.credits = credits;
    }

    public long getCoins() {
        return coins;
    }

    public void setCoins(long coins) {
        this.coins = coins;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public void message(String message) {
        getBukkitPlayer().sendMessage(message);
    }

}
