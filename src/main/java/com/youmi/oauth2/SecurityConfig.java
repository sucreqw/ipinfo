package com.youmi.oauth2;

import com.youmi.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.filter.CompositeFilter;
import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("oauth2ClientContext")
    @Autowired
    OAuth2ClientContext oauth2ClientContext;

    @Bean
    UserDao detailsService() {
        return new UserDao();
    }


    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
       /* Log logger = LogFactory.getLog(SecurityConfig.class);
        logger.info("HttpSecurity http");*/
        http.antMatcher("/**").authorizeRequests()
                .antMatchers("/", "/login**", "/webjars/**", "/test").permitAll()
                .anyRequest().authenticated().and().exceptionHandling()
                .and()
                .logout().
                logoutUrl("/logout").
                logoutSuccessUrl("/")
                .and()
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class)
                .formLogin();
        // @formatter:on
    }
    @Bean
    @ConfigurationProperties("facebook")
    public ClientResources facebook() {
        return new ClientResources("facebook");
    }

    private Filter ssoFilter() {
        CompositeFilter filter = new CompositeFilter();
        List<Filter> filters = new ArrayList();
        filters.add(ssoFilter(facebook(), "/login/facebook"));
        //filters.add(ssoFilter(github(), "/login/github", githubPrincipalExtractor));
        filter.setFilters(filters);
        return filter;
    }

    class ClientResources {
        public ClientResources() {
        }

        public ClientResources(String type) {
        }
    }

}
