package happysubin.javapractice.lab.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.nio.charset.StandardCharsets;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final ObjectMapper objectMapper;

    public SecurityConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        // ensure the passwords are encoded properly
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());
        return manager;
    }

    @Bean
    @Order(1)
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/key/**")
                .httpBasic(basic -> basic.disable())
                .formLogin(form -> form.disable())
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .sessionManagement(session -> {
                    session.disable();
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilterBefore(apiKeyFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(ex -> {
                    ex.accessDeniedHandler((request, response, accessDeniedException) -> {
                        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                        response.setStatus(HttpStatus.FORBIDDEN.value());
                        response.getWriter().write(objectMapper.writeValueAsString(new Result("API KEY 인가 오류")));
                    });
                    ex.authenticationEntryPoint((request, response, authException) -> {
                        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                        response.setStatus(HttpStatus.UNAUTHORIZED.value());
                        response.getWriter().write(objectMapper.writeValueAsString(new Result("API KEY 인증 오류")));
                    });
                });

        return http.build();
    }


    @Bean
    public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .exceptionHandling(ex -> {
                    ex.accessDeniedHandler((request, response, accessDeniedException) -> {
                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                        response.setStatus(HttpStatus.FORBIDDEN.value());
                        response.getWriter().write(objectMapper.writeValueAsString(new Result("API 인가 오류")));
                    });
                    ex.authenticationEntryPoint((request, response, authException) -> {
                        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                        response.setStatus(HttpStatus.UNAUTHORIZED.value());
                        response.getWriter().write(objectMapper.writeValueAsString(new Result("API 인증 오류")));
                    });
                });
        return http.build();
    }

    @Bean
    public ApiKeyFilter apiKeyFilter() {
        ApiKeyFilter apiKeyFilter = new ApiKeyFilter("/api/key/**", "key");
        apiKeyFilter.setAuthenticationManager(authentication -> null);
        return apiKeyFilter;
    }


    static class Result {
        private final String message;

        public Result(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}