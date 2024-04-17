package com.ds.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.ds.service.UrlShortenerService;

@RestController
@RequestMapping("TinyUrl")
public class UrlShortenerController {

	// Map to store original URLs and their corresponding aliases
    private Map<String, String> urlMap = new HashMap<>();

    // Service to generate short aliases for URLs
    @Autowired
    private UrlShortenerService urlShortenerService;

    // Endpoint to shorten a URL
    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody String originalUrl) {
       
    	// Generate a unique alias for the URL
        String alias = urlShortenerService.generateAlias(originalUrl);

        // Store the original URL and its alias
        urlMap.put(alias, originalUrl);

        // Return the alias as the shortened URL
        return new ResponseEntity<>("Shortened URL: " + alias, HttpStatus.OK);
    }

    // Endpoint to redirect to the original URL using the short alias
    @GetMapping("/{alias}")
    public RedirectView redirectToOriginalUrl(@PathVariable String alias) {
        
    	String originalUrl = urlMap.get(alias);
        
        if (originalUrl != null) {
        
        	// Redirect to the original URL
            return new RedirectView(originalUrl);
        
        } else {
        
        	// Return a 404 error if the alias is not found
            return new RedirectView("/", true);
        }
    }
}
