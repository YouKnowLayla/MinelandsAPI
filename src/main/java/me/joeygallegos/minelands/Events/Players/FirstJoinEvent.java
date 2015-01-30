package me.joeygallegos.minelands.Events.Players;

import me.joeygallegos.minelands.Core;
import me.joeygallegos.minelands.MinePlayers.MinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public final class FirstJoinEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private Player bukkitPlayer;
    private MinePlayer minePlayer;

    public FirstJoinEvent(Player bukkitPlayer, MinePlayer minePlayer) {
        this.bukkitPlayer = bukkitPlayer;
        this.minePlayer = minePlayer;

        Core.getPlugin().getLogger().info("FirstJoinEvent was fired for player " + bukkitPlayer.getName());
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getBukkitPlayer() {
        return bukkitPlayer;
    }

    public MinePlayer getMinePlayer() {
        return minePlayer;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
