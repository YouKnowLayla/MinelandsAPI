package me.joeygallegos.minelands.Listeners;

import me.joeygallegos.minelands.Events.MinelandEvent;
import me.joeygallegos.minelands.MinePlayers.MinePlayer;
import me.joeygallegos.minelands.MinePlayers.PlayerManager;
import me.joeygallegos.minelands.Util.Title.TitleSet;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class Test extends MinelandEvent {

    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent event) {
        TitleSet set = new TitleSet(
                "{ text: \"WELCOME TO\", color: gold, bold: true }",
                "{ text: \"REAL MYTH GAMING\", color: yellow, bold: true }"
        );
        set.setFadeInTime(2);
        set.setStayTime(5);
        set.setFadeOutTime(2);

        MinePlayer player = PlayerManager.getPlayer(event.getPlayer());
        set.send(player);
        event.getPlayer().sendMessage("§bMineland test listener works");
    }
}
