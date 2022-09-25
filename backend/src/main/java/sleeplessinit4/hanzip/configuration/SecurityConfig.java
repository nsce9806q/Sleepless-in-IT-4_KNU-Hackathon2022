package sleeplessinit4.hanzip.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import sleeplessinit4.hanzip.configuration.auth.JwtAuthenticationFilter;
import sleeplessinit4.hanzip.configuration.auth.JwtAuthorizationFilter;
import sleeplessinit4.hanzip.repository.ChildrenRepository;
import sleeplessinit4.hanzip.repository.HouseRepository;
import sleeplessinit4.hanzip.repository.ParentRepository;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
  private final CorsConfig corsConfig;
  private final HouseRepository houseRepository;
  private final ParentRepository parentRepository;
  private final ChildrenRepository childrenRepository;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .formLogin().disable()
        .httpBasic().disable()
        .apply(new MyCustomDsl())
        .and()
        .authorizeRequests(auth -> auth
            .antMatchers("/children/**").authenticated()
        .anyRequest().permitAll());

    return http.build();
  }

  public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {
    @Override
    public void configure(HttpSecurity http) throws Exception {
      AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
      http
          .addFilter(corsConfig.corsFilter())
          .addFilter(new JwtAuthenticationFilter(authenticationManager, houseRepository))
          .addFilter(new JwtAuthorizationFilter(authenticationManager, parentRepository, childrenRepository));
    }
  }

  @Bean
  public BCryptPasswordEncoder encodePassword(){
    return new BCryptPasswordEncoder();
  }
}