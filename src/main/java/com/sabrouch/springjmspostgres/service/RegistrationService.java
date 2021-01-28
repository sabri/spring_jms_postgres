package com.sabrouch.springjmspostgres.service;

import com.sabrouch.springjmspostgres.appUser.AppUserRole;
import com.sabrouch.springjmspostgres.appUser.Appuser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by sabrouch.
 * Date: 1/28/2021
 */
@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EMailValidation eMailValidation;

    public String register(RegistrationReguest request) {
        boolean isValidEmail = eMailValidation.test(request.getEmail());
        if (!isValidEmail){
           throw  new IllegalStateException("is not valid email");
        }
        return appUserService.signup(new Appuser(
                request.getName(),
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER
                ));
    }
}
