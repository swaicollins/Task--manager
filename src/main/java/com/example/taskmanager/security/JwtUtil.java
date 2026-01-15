package com.example.taskmanager.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;


public class JwtUtil {

    private static final String SECRET_KEY = "my_super_secure_secret_key_which_is_long_enough_123!";
    private static final long EXPIRATION_TIME = 86400000; // 1 day

    // Generate JWT token
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    // Validate JWT token and return username
    public static String validateToken(String token) throws Exception {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject();
        } catch (Exception e) {
            throw new Exception("Invalid or expired JWT token");
        }
    }
}


//public class JwtUtil {
//
//    private static final String SECRET_KEY = "my_super_secure_secret_key_which_is_long_enough_123!";
//    private static final long EXPIRATION_TIME = 86400000; // 1 day
//
//    // Generate JWT token
//    public static String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes(StandardCharsets.UTF_8))
//                .compact();
//    }
//
//    // Validate JWT token
//    public static String validateToken(String token) throws Exception {
//        try {
//            Claims claims = Jwts.parser()
//                    .setSigningKey(SECRET_KEY.getBytes(StandardCharsets.UTF_8))
//                    .parseClaimsJws(token)
//                    .getBody();
//
//            return claims.getSubject(); // return username
//        } catch (Exception e) {
//            throw new Exception("Invalid JWT token");
//        }
//    }
//}