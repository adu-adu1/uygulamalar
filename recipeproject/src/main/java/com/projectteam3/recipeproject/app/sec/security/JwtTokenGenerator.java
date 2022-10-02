package com.projectteam3.recipeproject.app.sec.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenGenerator {

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

    @Value("${jwt.expiration.time}")
    private Long EXPIRATION_TIME;


    public String generateJwtToken(Authentication authentication){
        JwtUserDetails jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
        Date expirationDate = new Date(new Date().getTime() + EXPIRATION_TIME);
        String token = Jwts.builder()
                .setSubject(jwtUserDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
        return token;
    }

    public String getUsernameByToken(String token) {
        Jws<Claims> claimsJws = parseToken(token);

        String username = claimsJws
                .getBody()
                .getSubject();

        return username;
    }

    public boolean validateToken(String token){

        boolean isValid;

        try {
            Jws<Claims> claimsJws = parseToken(token);
            isValid = !isTokenExpired(claimsJws);
        } catch (Exception e){
            isValid = false;
        }

        return isValid;
    }

    private Jws<Claims> parseToken(String token) {
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);
        return claimsJws;
    }

    private boolean isTokenExpired(Jws<Claims> claimsJws) {
        Date expirationDate = claimsJws.getBody().getExpiration();
        return expirationDate.before(new Date());
    }
}
