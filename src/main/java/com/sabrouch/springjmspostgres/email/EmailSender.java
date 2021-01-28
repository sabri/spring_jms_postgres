package com.sabrouch.springjmspostgres.email;

/**
 * Created by sabrouch.
 * Date: 1/28/2021
 */

public interface EmailSender {
    void send(String to, String email);
}
