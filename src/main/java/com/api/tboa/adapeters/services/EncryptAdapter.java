package com.api.tboa.adapeters.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public interface EncryptAdapter {
    static EncryptAdapter make() {
        return null;
    }

    @Bean String encrypt(String password);
    @Bean boolean compare(String password, String hash);
}
