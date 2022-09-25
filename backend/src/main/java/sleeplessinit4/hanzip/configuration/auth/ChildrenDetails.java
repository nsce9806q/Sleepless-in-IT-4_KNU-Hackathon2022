package sleeplessinit4.hanzip.configuration.auth;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sleeplessinit4.hanzip.entity.ChildrenEntity;

public class ChildrenDetails implements UserDetails {

  private final ChildrenEntity children;

  public ChildrenDetails(ChildrenEntity children) {
    this.children = children;
  }

  public String getChildname() {
    return children.getNickName();
  }

  public Long getChildrenId() {
    return children.getChildrenId();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    authorities.add(() -> { return "children";});

    return authorities;
  }

  @Override
  public String getPassword() {
    return children.getPassword();
  }

  @Override
  public String getUsername() {
    return children.getLoginId();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}

