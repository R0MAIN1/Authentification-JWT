package chillo.tech.avis.securite;

import chillo.tech.avis.entite.Utilisateur;
import chillo.tech.avis.service.UtilisateurService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
@Slf4j
@AllArgsConstructor
@Service
public class JwtService {

    private final String ENCRYPTION_KEY = "1dcbfde1520c810559d0cac90361c1ac92aeb3d627da6af0e2de662324809c95";
    private final UtilisateurService utilisateurService;

    public Map<String, String> generate(String username) {
        Utilisateur utilisateur = this.utilisateurService.loadUserByUsername(username);
        return this.generateJwt(utilisateur);
    }

    private Map<String, String> generateJwt(Utilisateur utilisateur) {

        Map<String, String> claims = Map.of(
                "nom", utilisateur.getNom(),
                "email", utilisateur.getEmail()
        );
        final long currentTime = System.currentTimeMillis();
        final long expirationTime = currentTime + 30 * 60 * 1000;

        final String bearer = Jwts.builder()
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(expirationTime))
                .setSubject(utilisateur.getEmail())
                .setClaims(claims)
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
        System.out.println(Map.of("bearer", bearer));
        return Map.of("bearer", bearer);


    }

    private Key getKey() {
        final byte[] decoder = Decoders.BASE64.decode(ENCRYPTION_KEY);
        return Keys.hmacShaKeyFor(decoder);
    }

    public String extractUsername(String token) {

        return null;
    }

    public boolean isTokenExpired(String token){
        Date expirationDate =
        return true;
    }
}
