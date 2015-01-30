package me.joeygallegos.minelands.Util.Title;

import me.joeygallegos.minelands.MinePlayers.MinePlayer;
import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.spigotmc.ProtocolInjector;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class TitleSet {

    private String titleJson;
    private String subtitleJson;

    private int fadeInTime;
    private int stayTime;
    private int fadeOutTime;

    public TitleSet(String titleJson, String subtitleJson) {
        this.titleJson = titleJson;
        this.subtitleJson = subtitleJson;
    }

    public void send(MinePlayer player) {
        sendTitle(player);
        sendSubtitle(player);
    }

    private void sendTitle(MinePlayer player) {
        ProtocolInjector.PacketTitle times = new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TIMES, fadeInTime, stayTime, fadeOutTime);
        ((CraftPlayer)player.getBukkitPlayer()).getHandle().playerConnection.sendPacket((net.minecraft.server.v1_8_R1.Packet) times);

        IChatBaseComponent chatTitle = ChatSerializer.a(titleJson);
        ProtocolInjector.PacketTitle title = new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TITLE, (net.minecraft.server.v1_7_R4.IChatBaseComponent) chatTitle);
        ((CraftPlayer)player.getBukkitPlayer()).getHandle().playerConnection.sendPacket((net.minecraft.server.v1_8_R1.Packet) title);
    }

    private void sendSubtitle(MinePlayer player) {
        ProtocolInjector.PacketTitle times = new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TIMES, fadeInTime, stayTime, fadeOutTime);
        ((CraftPlayer)player.getBukkitPlayer()).getHandle().playerConnection.sendPacket((net.minecraft.server.v1_8_R1.Packet) times);

        IChatBaseComponent chatSubtitle = ChatSerializer.a(subtitleJson);
        ProtocolInjector.PacketTitle subtitle = new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE, (net.minecraft.server.v1_7_R4.IChatBaseComponent) chatSubtitle);
        ((CraftPlayer)player.getBukkitPlayer()).getHandle().playerConnection.sendPacket((net.minecraft.server.v1_8_R1.Packet) subtitle);
    }

    public String getTitleJson() {
        return titleJson;
    }

    public String getSubtitleJson() {
        return subtitleJson;
    }

    public void setFadeInTime(int fadeInTime) {
        this.fadeInTime = fadeInTime;
    }

    public void setStayTime(int stayTime) {
        this.stayTime = stayTime;
    }

    public void setFadeOutTime(int fadeOutTime) {
        this.fadeOutTime = fadeOutTime;
    }
}
