package com.personalsite.wesleygene.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	//required to bypass default config, also plaintext isn't allowed will need {noop}
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Bean
    public PasswordEncoder passwordEncoder() {
        DelegatingPasswordEncoder delegatingPasswordEncoder = 
            (DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
        delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(new BCryptPasswordEncoder()); 
        return delegatingPasswordEncoder;
    }
	

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/getBlogsByCategory").permitAll()
                .requestMatchers("/api/v1/getBlogs").permitAll()
                .requestMatchers("/api/v1/delete/blog/comment").hasRole("ADMIN")
                .requestMatchers("/api/v1/delete/blog").hasRole("ADMIN")
                .requestMatchers("/api/v1/create/blog").hasRole("ADMIN")
                .requestMatchers("/api/v1/update/blog").hasRole("ADMIN")
                .anyRequest().authenticated()
			);
                //.cors(cors -> cors.configurationSource(corsConfigurationSource()));

		return http.build();
	}

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of("http://localhost:4200")); // 👈 Angular dev server
//        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(List.of("*"));
//        configuration.setAllowCredentials(true); // if you send cookies/auth headers
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/api/**", configuration);
//        return source;
//    }

    @Bean
    public UserDetailsService UserDetailsService(){
        UserDetails admin =
                User.withUsername("ADMIN")
                        .password("{noop}password123")
                        .roles("ADMIN")
                        .build();
        return new InMemoryUserDetailsManager(admin);
    }
	
}
