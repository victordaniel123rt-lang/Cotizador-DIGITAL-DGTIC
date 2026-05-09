package dgtic.core.security;

import dgtic.core.security.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.SecureRandom;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfiguration(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/cotizar/**","/nosotros/**","/coberturas/**" ,"/css/**", "/img/**", "/lib/**", "/scss/**", "/js/**","/Inicio/**","/imagenes/**","/Inicio3","/Inicio2","/enviar-pdf").permitAll() // recursos públicos
                        .requestMatchers("/Agregar/**").hasRole("Asesor")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login") // página personalizada
                        .defaultSuccessUrl("/Inicio")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL que dispara el logout
                        .logoutSuccessUrl("/") // a dónde va después
                        .invalidateHttpSession(true) // invalida sesión
                        .deleteCookies("JSESSIONID") // elimina cookie
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11, new SecureRandom());

    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http
                .getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }


}
