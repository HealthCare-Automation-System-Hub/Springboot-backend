package com.health.care.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ProxyController {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BACKEND_URL = "http://localhost:8080"; // Backend URL

    @GetMapping("/{path}")
    public ResponseEntity<String> proxyGet(@PathVariable String path) {
        String url = BACKEND_URL + "/api/" + path;
        return restTemplate.getForEntity(url, String.class);
    }

    @PostMapping("/{path}")
    public ResponseEntity<String> proxyPost(@PathVariable String path, @RequestBody String body) {
        String url = BACKEND_URL + "/api/" + path;
        return restTemplate.postForEntity(url, body, String.class);
    }
}
