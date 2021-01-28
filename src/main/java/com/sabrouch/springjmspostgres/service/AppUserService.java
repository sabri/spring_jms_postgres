package com.sabrouch.springjmspostgres.service;

import com.sabrouch.springjmspostgres.appUser.Appuser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by sabrouch.
 * Date: 1/27/2021
 */
@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
   private final AppUserRepository appUserRepository;
   private final BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException(String.format("user with email %s is not found", email)));
    }
    public String signup(Appuser appuser){
        boolean isExist = appUserRepository.findByEmail(appuser.getEmail()).isPresent();
        if (isExist){
            throw new IllegalStateException("email is already taken");
        }
        String encoded = bCryptPasswordEncoder.encode(appuser.getPassword());
        appuser.setPassword(encoded);
        appUserRepository.save(appuser);
        return "it works";
    }
}
