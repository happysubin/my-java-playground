package happysubin.javapractice.lab.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
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
    @Order(1)
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/key/**")
                .httpBasic(basic -> basic.disable())
                .formLogin(form -> form.disable())
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilterBefore(apiKeyFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain tempApiFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/state-machine/**")
                .httpBasic(basic -> basic.disable())
                .formLogin(form -> form.disable())
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                });

        return http.build();
    }


    @Bean
    @Order(3)
    public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
        http

                .httpBasic(basic -> basic.disable())
                .formLogin(form -> form.disable())
                .csrf(csrf-> csrf.disable())

                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())


                .addFilterBefore(apiKeyFilter2(), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .exceptionHandling(ex -> {


//                    ex.accessDeniedHandler((request, response, accessDeniedException) -> {
//                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//                        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
//                        response.setStatus(HttpStatus.FORBIDDEN.value());
//                        response.getWriter().write(objectMapper.writeValueAsString(new Result("API 인가 오류")));
//                    });
//
//
//                    ex.authenticationEntryPoint((request, response, authException) -> {
//                        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
//                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//                        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//                        response.getWriter().write(objectMapper.writeValueAsString(new Result("API 인증 오류")));
//                    });
                });
        return http.build();
    }

    public ApiKeyFilter apiKeyFilter() {
        ApiKeyFilter apiKeyFilter = new ApiKeyFilter(objectMapper, "key");
        return apiKeyFilter;
    }

    public ApiKey2Filter apiKeyFilter2() {
        ApiKey2Filter apiKeyFilter = new ApiKey2Filter("key", objectMapper);
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