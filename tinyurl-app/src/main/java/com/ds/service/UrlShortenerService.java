package com.ds.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {

	// Method to generate a short alias for a given URL
    public String generateAlias(String originalUrl) {
        // Generate a random UUID and extract the first 6 characters to use as the alias
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
