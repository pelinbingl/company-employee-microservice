package com.pelin.api_gateway;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class GatewayController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final JwtUtil jwtUtil;

    private final String COMPANY_SERVICE = "http://localhost:8081";
    private final String EMPLOYEE_SERVICE = "http://localhost:8082";

    public GatewayController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // Token kontrolü yapan yardımcı metod
    private boolean isTokenValid(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return false;
        }
        String token = authHeader.substring(7); // "Bearer " kısmını at
        return jwtUtil.validateToken(token);
    }

    // GET /companies
    @GetMapping("/companies")
    public ResponseEntity<String> getCompanies(
            @RequestHeader(value = "Authorization", required = false) String authHeader) {

        if (!isTokenValid(authHeader)) {
            return ResponseEntity.status(401).body("Yetkisiz erişim! Önce login olun.");
        }

        String response = restTemplate.getForObject(COMPANY_SERVICE + "/companies", String.class);
        return ResponseEntity.ok(response);
    }

    // POST /companies
    @PostMapping("/companies")
    public ResponseEntity<String> addCompany(
            @RequestHeader(value = "Authorization", required = false) String authHeader,
            @RequestBody String body) {

        if (!isTokenValid(authHeader)) {
            return ResponseEntity.status(401).body("Yetkisiz erişim! Önce login olun.");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        String response = restTemplate.postForObject(COMPANY_SERVICE + "/companies", entity, String.class);
        return ResponseEntity.ok(response);
    }

    // GET /employees
    @GetMapping("/employees")
    public ResponseEntity<String> getEmployees(
            @RequestHeader(value = "Authorization", required = false) String authHeader) {

        if (!isTokenValid(authHeader)) {
            return ResponseEntity.status(401).body("Yetkisiz erişim! Önce login olun.");
        }

        String response = restTemplate.getForObject(EMPLOYEE_SERVICE + "/employees", String.class);
        return ResponseEntity.ok(response);
    }

    // POST /employees
    @PostMapping("/employees")
    public ResponseEntity<String> addEmployee(
            @RequestHeader(value = "Authorization", required = false) String authHeader,
            @RequestBody String body) {

        if (!isTokenValid(authHeader)) {
            return ResponseEntity.status(401).body("Yetkisiz erişim! Önce login olun.");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        String response = restTemplate.postForObject(EMPLOYEE_SERVICE + "/employees", entity, String.class);
        return ResponseEntity.ok(response);
    }
}