package bin.Auth;

import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.context.*;

public class SecurityWebApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
        super(SecurityConfig.class);
    }
}