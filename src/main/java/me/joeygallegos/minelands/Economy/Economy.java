package me.joeygallegos.minelands.Economy;

import me.joeygallegos.minelands.Network.DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class Economy {

    public static void logTransaction(Transaction transaction) {

        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement("" +
                    "INSERT INTO transactions (id, time, from, action, price) VALUES (NULL, CURRENT_TIMESTAMP, ?, ?, ?);");
            stmt.setString(1, transaction.getFrom().getUniqueId().toString());
            stmt.setInt(2, transaction.getAction().getId());
            stmt.setLong(3, transaction.getPrice());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
