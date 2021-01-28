package com.sabrouch.springjmspostgres.controller;

import com.sabrouch.springjmspostgres.service.RegistrationReguest;
import com.sabrouch.springjmspostgres.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sabrouch.
 * Date: 1/28/2021
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/v1/registration")
public class Registration {



    private final RegistrationService registrationService;
    @PostMapping
    public String register (@RequestBody RegistrationReguest request){
        return registrationService.register(request);
    }
}
