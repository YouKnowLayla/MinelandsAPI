package me.joeygallegos.minelands.Economy;

import me.joeygallegos.minelands.MinePlayers.MinePlayer;

import java.sql.Timestamp;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class Transaction {

    private int id;
    private Timestamp time;
    private MinePlayer from;
    private EconomyAction action;
    private long price;

    public Transaction(Timestamp time, MinePlayer from, EconomyAction action, long price) {
        this.time = time;
        this.from = from;
        this.action = action;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public MinePlayer getFrom() {
        return from;
    }

    public void setFrom(MinePlayer from) {
        this.from = from;
    }

    public EconomyAction getAction() {
        return action;
    }

    public void setAction(EconomyAction action) {
        this.action = action;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
