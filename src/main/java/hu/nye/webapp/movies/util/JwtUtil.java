package hu.nye.webapp.movies.util;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import hu.nye.webapp.movies.configuration.JwtConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
public class JwtUtil {

    private static final String USERNAME_CLAIM = "username";

    private final Algorithm algorithm;
    private final JWTVerifier jwtVerifier;
    private final DateUtil dateUtil;
    private final JwtConfigurationProperties jwtConfigurationProperties;

    public JwtUtil(Algorithm algorithm, JWTVerifier jwtVerifier, DateUtil dateUtil,
                   JwtConfigurationProperties jwtConfigurationProperties) {
        this.algorithm = algorithm;
        this.jwtVerifier = jwtVerifier;
        this.dateUtil = dateUtil;
        this.jwtConfigurationProperties = jwtConfigurationProperties;
    }

    public String createAndSignToken(String username) {
        return JWT.create()
            .withIssuer(jwtConfigurationProperties.getIssuer())
            .withClaim(USERNAME_CLAIM, username)
            .withExpiresAt(createExpirationDate())
            .sign(algorithm);
    }

    public String verifyAndDecodeToken(String token) {
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        return decodedJWT.getClaim(USERNAME_CLAIM).asString();
    }

    private Date createExpirationDate() {
        return Date.from(
            dateUtil.now().toInstant().plus(jwtConfigurationProperties.getTokenValidityInMinutes(), ChronoUnit.MINUTES)
        );
    }

}
