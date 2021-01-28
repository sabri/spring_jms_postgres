package com.sabrouch.springjmspostgres.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by sabrouch.
 * Date: 1/28/2021
 */
@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private ConfirmationTokenRepository confirmationTokenRepository;
    public void confirmationSaveToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }
}
