package org.ovd.edu.springbootJsf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelDecisionManagerImpl;

/**
 * Created by Sergey.Ovdienko on 20.10.2016.
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password("user").roles("USER")
            .and()
            .withUser("admin").password("admin").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //.authorizeRequests()
//           .anyRequest().authenticated() //all requests will checked
            //.and()
            .csrf().disable()
            .formLogin()
                .loginPage("/app/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/app/checkuser")/*j_spring_security_check*/
                .defaultSuccessUrl("/app/main", true)
                .failureUrl("/app/login?login_failed=1")
                //.permitAll()
                .and()
            .logout()
                .logoutUrl("/app/logout")
                .logoutSuccessUrl("/app/login")
                //.permitAll()
                .and()
            //.antMatcher ( "/**" ).authorizeRequests().anyRequest().fullyAuthenticated()
            .authorizeRequests()
                //.antMatchers("/app/javax.faces.resource/**").permitAll()
                .antMatchers("/app/main/**")
                //.antMatchers("/resources/**,/res/**").requires(ChannelDecisionManagerImpl.ANY_CHANNEL)
                .authenticated();


    }


}
