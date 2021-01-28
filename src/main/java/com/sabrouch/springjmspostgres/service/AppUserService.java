package com.sabrouch.springjmspostgres.service;

import com.sabrouch.springjmspostgres.appUser.Appuser;
import com.sabrouch.springjmspostgres.token.ConfirmationToken;
import com.sabrouch.springjmspostgres.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by sabrouch.
 * Date: 1/27/2021
 */
@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
   private final AppUserRepository appUserRepository;
   private final BCryptPasswordEncoder bCryptPasswordEncoder;
   private final ConfirmationTokenService confirmationTokenService;

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
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken=new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().minusDays(15),
                appuser
        );
        confirmationTokenService.saveConfirmationToken(
                confirmationToken);
        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
