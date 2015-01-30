package me.joeygallegos.minelands.Exceptions;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class DataDownloadException extends Exception {

    private String message;

    public DataDownloadException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
