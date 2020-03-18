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

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserRepository userRepo;

    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**","/resources/**/**", "/", "/login**", "/registration", "/h2-console/**", "/api/**", "/api/**/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/topics/").failureUrl("/login?error").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout").permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

    }

}

