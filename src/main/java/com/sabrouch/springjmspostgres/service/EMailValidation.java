package com.sabrouch.springjmspostgres.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

/**
 * Created by sabrouch.
 * Date: 1/28/2021
 */
@Service
@AllArgsConstructor
public class EMailValidation implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return true;
    }
}
