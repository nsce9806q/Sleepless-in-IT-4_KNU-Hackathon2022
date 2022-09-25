package sleeplessinit4.hanzip.configuration.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import sleeplessinit4.hanzip.entity.ChildrenEntity;
import sleeplessinit4.hanzip.entity.ParentEntity;
import sleeplessinit4.hanzip.repository.ChildrenRepository;
import sleeplessinit4.hanzip.repository.ParentRepository;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
  private final ParentRepository parentRepository;
  private final ChildrenRepository childrenRepository;

  public JwtAuthorizationFilter(AuthenticationManager authenticationManager,
      ParentRepository parentRepository, ChildrenRepository childrenRepository) {
    super(authenticationManager);
    this.parentRepository = parentRepository;
    this.childrenRepository = childrenRepository;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    String header = request.getHeader(JwtProperties.HEADER_STRING);
    if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
      chain.doFilter(request, response);
      return;
    }
    System.out.println("header : " + header);
    String token = request.getHeader(JwtProperties.HEADER_STRING)
        .replace(JwtProperties.TOKEN_PREFIX, "");

    // 토큰 검증 (이게 인증이기 때문에 AuthenticationManager도 필요 없음)
    // 내가 SecurityContext에 집적접근해서 세션을 만들때 자동으로 UserDetailsService에 있는
    // loadByUsername이 호출됨.
    Long id = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(token)
        .getClaim("id").asLong();
    String role = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(token)
        .getClaim("role").asString();

    Authentication authentication;
    if (Objects.equals(role, "parent")) {
      ParentEntity parent = parentRepository.findById(id).orElseThrow(null);

      ParentDetails parentDetails = new ParentDetails(parent);
      authentication = new UsernamePasswordAuthenticationToken(
          parentDetails,
          null,
          parentDetails.getAuthorities()
      );

      System.out.println(parentDetails.getAuthorities().toString());
    } else {
      ChildrenEntity children = childrenRepository.findById(id).orElseThrow(null);

      ChildrenDetails childrenDetails = new ChildrenDetails(children);
      authentication = new UsernamePasswordAuthenticationToken(
          childrenDetails,
          null,
          childrenDetails.getAuthorities()
      );

      System.out.println(childrenDetails.getAuthorities().toString());
    }

    // 강제로 시큐리티의 세션에 접근하여 값 저장
    SecurityContextHolder.getContext().setAuthentication(authentication);
    chain.doFilter(request, response);
  }

}
