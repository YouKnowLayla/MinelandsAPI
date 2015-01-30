package me.joeygallegos.minelands.MinePlayers.Bans;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class Ban {

    // ID
    private long id;

    // TIME
    private Timestamp timeCreated;

    // TEMP OR PERM
    private BanType banType;

    // PERSONS
    private UUID offender;
    private UUID creator;

    // REASON | CAN NULL
    private String reason;

}
