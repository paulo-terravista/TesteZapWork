package br.com.terravista.limitecredito;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http
			.authorizeRequests()
			.antMatchers(HttpMethod.TRACE, "/**").denyAll()
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.antMatchers("/admin/**").authenticated()
			.anyRequest().permitAll()
			.and().httpBasic()
			.and().headers().frameOptions().disable()
			.and().csrf().disable();
		}


	}
