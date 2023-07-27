package nurse.world.utils;

import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Singleton;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Singleton
public class AmazonJwtService {
    public String generateJwt(){
        Set<String> roles = new HashSet<>(
                Arrays.asList("admin", "writer")
        );
        return Jwt.issuer("nurse-world-jwt")
                .subject("nurse-world-jwt")
                .groups(roles)
                .expiresAt(
                        System.currentTimeMillis() + 3600
                )
                .sign();
    }
}
