
package com.mathologic.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mathologic.projects.repository.UserRepository;
import com.mathologic.projects.service.SSUserDetailsService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter  {
	
	@Autowired private UserRepository userRepository;

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
        .authorizeRequests()
        	.antMatchers("/bower_components/**").permitAll()
        	.antMatchers("/login/**").permitAll()
        	 .anyRequest().fullyAuthenticated()
            .antMatchers("/admin/**").hasAuthority("ADMIN")
            .antMatchers("/user/**").hasAuthority("USER")
            .antMatchers("/api/v1/role/**").hasAuthority("ADMIN")
            .antMatchers("/api/v1/currentUser/**").permitAll()
            
            .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login/login.html").permitAll(true)
        //.formLogin()
        .and()
        .logout().permitAll()
        .and().httpBasic().and().csrf().disable()
        .sessionManagement()
        .maximumSessions(1)
    ;
}
		
	
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
     	auth.userDetailsService(userDetailsServiceBean());
    }
	@Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new SSUserDetailsService(userRepository);
    }

}