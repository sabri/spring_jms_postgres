package com.sabrouch.springjmspostgres.appUser.service;

import com.sabrouch.springjmspostgres.appUser.Appuser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by sabrouch.
 * Date: 1/27/2021
 */
@Transactional(readOnly = true)
@Repository
public interface AppUserRepository {
    Optional<Appuser> findByEmail(String email);
}
