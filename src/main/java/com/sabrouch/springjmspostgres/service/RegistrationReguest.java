package com.sabrouch.springjmspostgres.service;

import lombok.*;

/**
 * Created by sabrouch.
 * Date: 1/28/2021
 */
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationReguest {

    private final String name;
    private final String username;
    private final String email;
    private final String password;




}
