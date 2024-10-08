package happysubin.javapractice.lab.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import java.util.Collections;

public class ApiKeyFilter extends AbstractAuthenticationProcessingFilter {

    private final String apiKey;

    protected ApiKeyFilter(String defaultFilterProcessesUrl, String apiKey) {
        super(defaultFilterProcessesUrl);
        this.apiKey = apiKey;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String key = request.getHeader("API-KEY");

        if(key == null || !key.equals(apiKey)) {
            throw new AuthenticationServiceException("KEY ERROR");
        }

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("PASS", null, Collections.emptyList());
        SecurityContextHolder.getContext().setAuthentication(token);
        return token;
    }
}
