package me.joeygallegos.minelands.Ranks;

import org.bukkit.ChatColor;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public enum Rank {

    DEFAULT(0, "Default", ChatColor.DARK_GRAY),
    PRO(1, "Pro", ChatColor.GREEN),
    PLATINUM(2, "Platinum", ChatColor.GRAY),
    ELITE(3, "Elite", ChatColor.LIGHT_PURPLE),
    MOD(4, "Mod", ChatColor.DARK_AQUA),
    ADMIN(5, "Admin", ChatColor.RED),
    MANAGER(6, "Manager", ChatColor.GOLD),
    OWNER(7, "Owner", ChatColor.DARK_RED);

    private int id;
    private String name;
    private ChatColor color;

    Rank(int id, String name, ChatColor color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public static Rank getById(int id) {
        for (Rank rank : values()) {
            if (rank.getId() == id) {
                return rank;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }

}
