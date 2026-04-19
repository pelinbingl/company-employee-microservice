package com.pelin.api_gateway;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // POST /login → kullanıcı adı ve şifre al, token döndür
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String password = request.get("password");

        // Şimdilik basit kontrol — FAZ gerçek DB ile yapılır
        if ("admin".equals(username) && "1234".equals(password)) {
            String token = jwtUtil.generateToken(username);
            return Map.of("token", token);
        }

        throw new RuntimeException("Geçersiz kullanıcı adı veya şifre!");
    }
}