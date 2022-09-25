package sleeplessinit4.hanzip.configuration.auth;

public interface JwtProperties {
  String SECRET = "HANZIP";
  int ACCESS_TOKEN_EXPIRATION_TIME = 3600000; // 30분
  String TOKEN_PREFIX = "Bearer ";
  String HEADER_STRING = "Authorization";
}