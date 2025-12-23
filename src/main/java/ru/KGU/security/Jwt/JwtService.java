package ru.KGU.security.Jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.KGU.rest.dto.JwtAuthenticationDto;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtService {

    private static final Logger LOGGER = LogManager.getLogger(JwtService.class);
    @Value("e4ed3a1c1a30763e2aa56084c38bc69c99d2ec6ca694cbc0a8c9c88d83282ab7")
    private String secret;


    public JwtAuthenticationDto generateAuthToken(String id){
        JwtAuthenticationDto jwtDto = new JwtAuthenticationDto();
        jwtDto.setToken(generateJwtToken(id));
        jwtDto.setRefreshToken(generateRefreshToken(id));
        return jwtDto;
    }

    public JwtAuthenticationDto refreshBaseToken(String id, String refreshToken) {
        JwtAuthenticationDto jwtDto = new JwtAuthenticationDto();
        jwtDto.setToken(generateJwtToken(id));
        jwtDto.setRefreshToken(refreshToken);
        return jwtDto;
    }

    public String getIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try{
            Jwts.parser()
                    .verifyWith(getSignInKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return true;
        }catch (ExpiredJwtException e){
            LOGGER.error("Expired JWTException", e);

        }catch (UnsupportedJwtException e){
            LOGGER.error("Unsupported JWTException", e);
        }catch (MalformedJwtException e){
            LOGGER.error("Malformed JWTException", e);
        }catch (SecurityException e){
            LOGGER.error("SecurityException", e);
        }catch (Exception e){
            LOGGER.error("Exception", e);
        }
        return false;
    }



    private String generateJwtToken(String id) {
        Date date = Date.from(LocalDateTime.now().plusMinutes(1).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(id)
                .expiration(date)
                .signWith(getSignInKey())
                .compact();

    }
    private String generateRefreshToken(String id) {
        Date date = Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(id)
                .expiration(date)
                .signWith(getSignInKey())
                .compact();

    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
