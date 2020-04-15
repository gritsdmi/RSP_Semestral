package cz.cvut.fel.rsp.tripguide.config;

import cz.cvut.fel.rsp.tripguide.repository.UserRepository;
import cz.cvut.fel.rsp.tripguide.security.AuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProvider authProvider;

    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**","/resources/**/**", "/static/**", "/static/**/**", "/templates/**","templates/**/**", "/", "/login**", "/registration", "/h2-console/**", "/api/**", "/api/**/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/tourist/**").hasAuthority("TOURIST")
                .antMatchers("/delegate/**").hasAuthority("DELEGATE")
                .antMatchers("/guest/**").anonymous()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/home").failureUrl("/login?error").permitAll()
                .and().logout().logoutSuccessUrl("/guest/home").permitAll();

        http.headers().frameOptions().sameOrigin();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("TOURIST")
                .and()
                .withUser("admin").password("{noop}password").roles("TOURIST", "DELEGATE", "ADMIN");

    }

}

