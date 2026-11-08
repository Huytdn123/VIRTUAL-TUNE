package com.virtualtune.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * HealthController - Ultra-lightweight health check endpoints for cloud deployment (Render/Docker).
 * Provides immediate HTTP 200 responses for Render root probe (GET /) and API probe (GET /api/health)
 * without querying database or consuming heavy memory/CPU cycles.
 */
@RestController
public class HealthController {

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> rootHealth() {
        return ResponseEntity.ok(Map.of(
                "status", "UP",
                "service", "Virtual Tune Backend",
                "version", "1.0.0"
        ));
    }

    @GetMapping("/api/health")
    public ResponseEntity<Map<String, Object>> apiHealth() {
        return ResponseEntity.ok(Map.of(
                "status", "UP",
                "service", "Virtual Tune API",
                "version", "1.0.0"
        ));
    }
}

