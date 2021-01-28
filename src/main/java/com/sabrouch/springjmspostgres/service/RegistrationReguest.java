package com.sabrouch.springjmspostgres.service;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by sabrouch.
 * Date: 1/28/2021
 */
@AllArgsConstructor
@Data

public class RegistrationReguest {

    private final String name;
    private final String username;
    private final String email;
    private final String password;




}
