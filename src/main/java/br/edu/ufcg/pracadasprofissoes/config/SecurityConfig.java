package br.edu.ufcg.pracadasprofissoes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.edu.ufcg.pracadasprofissoes.security.JWTAuthenticationFilter;
import br.edu.ufcg.pracadasprofissoes.security.JWTAuthorizationFilter;
import br.edu.ufcg.pracadasprofissoes.security.JWTUtil;
import br.edu.ufcg.pracadasprofissoes.util.RestConstants;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
    private Environment environment;

	private static final String h2 = "/h2-console/**";
	
	private static final String swagger = "/swagger-ui/**";
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
//		if (Arrays.asList(environment.getActiveProfiles()).contains("test")) {
//            http.headers().frameOptions().disable();
//        }
		http.headers().frameOptions().disable();
		http.cors().and().csrf().disable();
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST, RestConstants.ESCOLA_URI).permitAll()
			.antMatchers(HttpMethod.POST, RestConstants.USUARIO_URI).permitAll()
			.antMatchers(HttpMethod.POST, RestConstants.API_URI+"/usuario/login").permitAll()
			.antMatchers(HttpMethod.GET, RestConstants.ESTADO_URI+"/**").permitAll()
			.antMatchers(HttpMethod.GET, RestConstants.CIDADE_URI+"/**").permitAll()
			.antMatchers("/swagger-ui/#/**").permitAll()
			.antMatchers("/v2/api-docs/**").permitAll()
			.antMatchers("/swagger-resources/**").permitAll()
			.antMatchers("swagger-ui.html").permitAll()
			.antMatchers("webjars/**").permitAll()
			.antMatchers(swagger).permitAll()
			.antMatchers(h2).permitAll()
			.anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.httpBasic().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration cors = new CorsConfiguration().applyPermitDefaultValues();
		cors.addAllowedOrigin("*");
		source.registerCorsConfiguration("/**", cors);
		return source;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
