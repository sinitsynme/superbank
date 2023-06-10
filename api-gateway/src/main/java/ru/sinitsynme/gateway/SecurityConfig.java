package ru.sinitsynme.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity, ServerLogoutSuccessHandler handler) {
        httpSecurity
                .authorizeExchange().pathMatchers("/").permitAll().and()
                .authorizeExchange().anyExchange().authenticated().and()
                .oauth2Login(Customizer.withDefaults()).logout().logoutSuccessHandler(handler);

        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }

    @Bean
    public ServerLogoutSuccessHandler oidcLogoutSuccessHandler(ReactiveClientRegistrationRepository repository) {
        OidcClientInitiatedServerLogoutSuccessHandler oidcLogoutSuccessHandler =
                new OidcClientInitiatedServerLogoutSuccessHandler(repository);
        oidcLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}/");

        return oidcLogoutSuccessHandler;
    }


}
