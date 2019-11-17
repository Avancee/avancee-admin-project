package com.github.avancee.admin.security;

import com.github.avancee.admin.security.handler.DefaultAccessDeniedHandler;
import com.github.avancee.admin.security.handler.DefaultAuthenticationEntryPoint;
import com.github.avancee.admin.security.handler.DefaultLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import static com.github.avancee.admin.constant.SecurityConst.*;

/**
 * OAuth2ServerConfig
 *
 * @author byference
 * @since 2019-11-02
 */
@Configuration
public class OAuth2ServerConfig {


    /**
     * ResourceServer
     */
    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId(ADMIN_RESOURCE_ID)
                    .stateless(true)
                    .authenticationEntryPoint(new DefaultAuthenticationEntryPoint())
                    .accessDeniedHandler(new DefaultAccessDeniedHandler());
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .requestMatchers().anyRequest()
                    .and()
                    .anonymous()
                    .and()
                    .authorizeRequests()
                    //.antMatchers("/anonymous/**").permitAll()
                    .anyRequest().authenticated()
                    .and().logout().logoutSuccessHandler(new DefaultLogoutSuccessHandler());
        }
    }


    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private RedisConnectionFactory redisConnectionFactory;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory()
                    .withClient(ADMIN_CLIENT_ID)
                    .resourceIds(ADMIN_RESOURCE_ID)
                    .secret(passwordEncoder.encode(ADMIN_SECRET))
                    .authorizedGrantTypes("password", "refresh_token")
                    .scopes("select")
                    .authorities("client")
                    .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
                    .refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_SECONDS);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) {
            security.allowFormAuthenticationForClients();
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory))
                    .authenticationManager(authenticationManager);
        }
    }

}
