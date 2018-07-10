package ro.ne8.authorizationserver;

import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Security;

@SpringBootApplication
public class AuthorizationServerApplication {

    public static void main(final String[] args) {
        Security.addProvider(new BouncyCastleFipsProvider());
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }
}
