package LearningManagementSystem.Component;

import LearningManagementSystem.requestObjects.Access;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration; // in milliseconds

    public String generateToken(Access userDetails , String mail) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("name",userDetails.getName() );
        claims.put("role",userDetails.getRole() );
        claims.put("id",userDetails.getId() );
        claims.put("email" , mail);



        return createToken(claims, userDetails.getName());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    public Boolean validateToken(String token ) {
        Claims claims = extractAllClaims(token);
        String subject = claims.getSubject();
        final String extractedUsername = claims.getSubject();
        final Integer id =  Integer.parseInt( claims.get("id").toString() );
        final String extracMail = claims.get("email").toString();
//        System.out.println(id + " " + extracMail+ " " + username);
//        System.out.println(extractedUsername.equals(username) );
        return (extractedUsername.equals(subject) && !isTokenExpired(token) );
    }

    //integer id
    public Boolean validateToken(String token, String username , Integer userId ) {
        Claims claims = extractAllClaims(token);
        final String extractedUsername = claims.getSubject();
        final Integer id =  Integer.parseInt( claims.get("id").toString() );
        final String extracMail = claims.get("email").toString();
//        System.out.println(id + " " + extracMail+ " " + username);
//        System.out.println(extractedUsername.equals(username) );
        return (extractedUsername.equals(username) && !isTokenExpired(token) && id.equals(userId)  );
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
