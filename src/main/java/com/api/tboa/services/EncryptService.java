package com.api.tboa.services;

import com.api.tboa.adapeters.services.EncryptAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class EncryptService implements EncryptAdapter {
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static EncryptAdapter make() {
        return new EncryptService();
    }

    @Override
    public String encrypt(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public boolean compare(String password, String hash) {
        return bCryptPasswordEncoder.matches(password, hash);
    }
}
