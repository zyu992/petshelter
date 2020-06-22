package ca.mcgill.ecse321.petshelter.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties("jwt.config")
public class TokenUtil {

    public static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public long ttl;

    public String generateJWT(Integer id, String name, Map<String, Object> map) {
        if (id == null || name == null)
            throw new IllegalArgumentException();
        long cur = System.currentTimeMillis();
        long exp = cur + ttl;
        return Jwts.builder()
                .setSubject(name)
                .setId(String.valueOf(id))
                .setIssuedAt(new Date(cur))
                .setExpiration(new Date(exp))
                .signWith(secretKey)
                .compact();
    }

    public static Claims validateJWT(String token) {
        try {
            return
                    Jwts.parser()
                            .setSigningKey(secretKey)
                            .parseClaimsJws(token)
                            .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
