package com.koreait.cloneinstagram.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private CustomOAuth2UserService customOauth2UserService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/user/signin", "/user/singup").permitAll()
                .anyRequest().authenticated();

        http.oauth2Login()
                .loginPage("/user/signin")
                .defaultSuccessUrl("/feed")
                .failureUrl("/user/signin")
                .userInfoEndpoint() //OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당합니다.
                .userService(customOauth2UserService);

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/signout"))
                .logoutSuccessUrl("/user/signin")
                .invalidateHttpSession(true);
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
    }
}
