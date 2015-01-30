package me.joeygallegos.minelands.MinePlayers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class PlayerCache {

    private static Map<UUID, MinePlayer> cache = new HashMap<UUID, MinePlayer>();

    public static Map<UUID, MinePlayer> getCache() {
        return cache;
    }

    /**
     * Gets all MinePlayers from the player cache
     *
     * @return Collection
     */
    public static java.util.Collection<MinePlayer> getOnlinePlayers() {
        return cache.values();
    }

}