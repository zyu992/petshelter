package ca.mcgill.ecse321.petshelter.util;

import java.util.Date;

import ca.mcgill.ecse321.petshelter.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenUtil {
    public static final String SUBJECT = "CODING";

    public static final String SECRETKEY = "petshelter";

    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;

    public static String generateJWT(User user){
        if (user == null || user.getUserId() == null || user.getUsername() == null ||
            user.getEmail() == null)
            return null;
        return Jwts.builder()
        .setSubject(SUBJECT)
        .claim("userId", user.getUserId())
        .claim("username", user.getUsername())
        .claim("email", user.getEmail())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
        .signWith(SignatureAlgorithm.ES256, SECRETKEY)
        .compact();
    }

    public static Claims validateJWT(String token) {
        try {
            final Claims claims = Jwts.parserBuilder().build()
            .parseClaimsJwt(token).getBody();
            return claims;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
