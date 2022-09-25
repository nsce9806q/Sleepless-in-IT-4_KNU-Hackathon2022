package sleeplessinit4.hanzip.configuration.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sleeplessinit4.hanzip.dto.request.LoginRequestDto;
import sleeplessinit4.hanzip.entity.HouseEntity;
import sleeplessinit4.hanzip.repository.HouseRepository;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  private final AuthenticationManager authenticationManager;
  private final HouseRepository houseRepository;

  private LoginRequestDto loginRequestDto = null;

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {

    ObjectMapper om = new ObjectMapper();
    try {
      loginRequestDto = om.readValue(request.getInputStream(), LoginRequestDto.class);
    } catch (Exception e) {
      e.printStackTrace();
    }

    UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(
            loginRequestDto.getLoginId(), loginRequestDto.getPassword());

    return authenticationManager.authenticate(authenticationToken);
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authResult) throws IOException, ServletException {

    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> json = new HashMap<String, Object>();

    String role;
    Long id;
    Long houseId;
    String houseName;


    if(authResult.getPrincipal().getClass() == ParentDetails.class) {
      ParentDetails parentDetails = (ParentDetails) authResult.getPrincipal();

      id =  parentDetails.getParentId();
      HouseEntity house = houseRepository.findByParentId(id);

      role = "parent";
      houseId = house.getHouseId();
      houseName = house.getHouseName();

    } else {
      ChildrenDetails childrenDetails = (ChildrenDetails) authResult.getPrincipal();

      id =  childrenDetails.getChildrenId();
      HouseEntity house = houseRepository.findByChildrenId(id);

      role = "children";
      houseId = house.getHouseId();
      houseName = house.getHouseName();

      json.put("child_name",childrenDetails.getChildname());
    }

    String accessToken = JWT.create()
        .withSubject(Long.toString(id))
        .withExpiresAt(new Date(System.currentTimeMillis()+ JwtProperties.ACCESS_TOKEN_EXPIRATION_TIME))
        .withClaim("id",id)
        .withClaim("ROLE",role)
        .sign(Algorithm.HMAC512(JwtProperties.SECRET));

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    json.put("access_token",JwtProperties.TOKEN_PREFIX+accessToken);
    json.put("id",id);
    json.put("role",role);
    json.put("house_id",houseId);
    json.put("house_name",houseName);

    response.getWriter().write(mapper.writeValueAsString(json));
  }
}
