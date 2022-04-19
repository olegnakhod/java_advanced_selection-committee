package academy.lgs.selection_committee.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import academy.lgs.selection_committee.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses=CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	
	public void configAuthentification (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/home").access("hasRole('ROLE_CANDIDATE') or hasRole('ROLE_ADMINISTRATOR')")
		.antMatchers("/editProfile").access("hasRole('ROLE_CANDIDATE') or hasRole('ROLE_ADMINISTRATOR')")
		.antMatchers("/addCertificate").access("hasRole('ROLE_CANDIDATE')")
		.antMatchers("/applyToFaculty").access("hasRole('ROLE_CANDIDATE')")
		.antMatchers("/addFaculty").access("hasRole('ROLE_ADMINISTRATOR')")
		.antMatchers("/viewCandidateInFaculty").access("hasRole('ROLE_ADMINISTRATOR')").anyRequest().permitAll().and()
		
		
		.formLogin().loginPage("/login")
		.defaultSuccessUrl("/home").usernameParameter("email").passwordParameter("password").and()
		.logout().logoutSuccessUrl("/login?logout").and()
		.exceptionHandling().accessDeniedPage("/403").and()
		.csrf();
	}

}
