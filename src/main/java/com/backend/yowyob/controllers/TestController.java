package com.backend.yowyob.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
@Tag(name = "Test", description = "API de test")
public class TestController {

    @Operation(summary = "Test de santé de l'API")
    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "OK");
        status.put("message", "Yowyob API is running");
        status.put("timestamp", java.time.LocalDateTime.now().toString());
        return status;
    }

    @Operation(summary = "Version de l'API")
    @GetMapping("/version")
    public Map<String, String> version() {
        Map<String, String> version = new HashMap<>();
        version.put("version", "1.0.0");
        version.put("name", "Yowyob Tiers API");
        return version;
    }
}