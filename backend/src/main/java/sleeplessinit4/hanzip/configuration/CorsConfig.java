package sleeplessinit4.hanzip.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

  @Bean
  public CorsFilter corsFilter(){
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();

    config.setAllowCredentials(true); // 서버에서 응답 한 json을 자바스크립트에서 처리할 수 있게 설정
    config.addAllowedOriginPattern("*"); // 모든 ip의 응답을 허용, allowcredentials=true 사용시 allowedorigin("*") 사용금지, allowedoriginpattern 사용 (https://kim6394.tistory.com/273)
    config.addAllowedHeader("*"); // 모든 헤더의 응답을 허용
    config.addAllowedMethod("*"); // POST GET PUT DELETE 등 모든 메소드 허용

    source.registerCorsConfiguration("/**", config); // 모든 url에 대해 위 config 적용
    return new CorsFilter(source);
  }
}
