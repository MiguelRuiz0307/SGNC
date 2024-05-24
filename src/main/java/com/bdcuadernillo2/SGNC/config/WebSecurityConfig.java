package com.bdcuadernillo2.SGNC.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Lenovo
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Define un `PasswordEncoder` que utiliza BCrypt para el cifrado de
     * contraseñas.
     *
     * @return una instancia de `BCryptPasswordEncoder`.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configura la cadena de filtros de seguridad.
     *
     * @param http el objeto `HttpSecurity` para configurar la seguridad HTTP.
     * @return la cadena de filtros de seguridad configurada.
     * @throws Exception si ocurre un error en la configuración.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests
                        -> authorizeRequests
                        .requestMatchers("/", "/bienvenida", "/register").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin
                        -> formLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/inicio", true)
                        .permitAll()
                )
                .logout(logout
                        -> logout.permitAll()
                );
        return http.build();
    }

    /**
     * Proporciona el `AuthenticationManager` utilizado por la aplicación.
     *
     * @param authenticationConfiguration la configuración de autenticación.
     * @return el `AuthenticationManager`.
     * @throws Exception si ocurre un error al obtener el
     * `AuthenticationManager`.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    
}
