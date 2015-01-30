package me.joeygallegos.minelands.Economy;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public enum EconomyAction {

    DEPOSIT(0), WITHDRAW(1);

    private int id;

    EconomyAction(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
