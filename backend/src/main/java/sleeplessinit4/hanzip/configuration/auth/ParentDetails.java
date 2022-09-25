package sleeplessinit4.hanzip.configuration.auth;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sleeplessinit4.hanzip.entity.ParentEntity;

public class ParentDetails implements UserDetails {

  private final ParentEntity parent;

  public ParentDetails(ParentEntity parent) {
    this.parent = parent;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    authorities.add(() -> { return "parent";});

    return authorities;
  }

  public Long getParentId() {
    return parent.getParentId();
  }

  @Override
  public String getPassword() {
    return parent.getPassword();
  }

  @Override
  public String getUsername() {
    return parent.getLoginId();
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
