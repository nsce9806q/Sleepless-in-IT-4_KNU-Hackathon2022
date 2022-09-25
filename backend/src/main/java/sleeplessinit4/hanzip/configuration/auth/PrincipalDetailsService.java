package sleeplessinit4.hanzip.configuration.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sleeplessinit4.hanzip.entity.ChildrenEntity;
import sleeplessinit4.hanzip.entity.ParentEntity;
import sleeplessinit4.hanzip.repository.ChildrenRepository;
import sleeplessinit4.hanzip.repository.ParentRepository;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

  private final ParentRepository parentRepository;
  private final ChildrenRepository childrenRepository;

  @Override
  public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
    ParentEntity parent = parentRepository.findByLoginId(loginId);
    if(parent == null){
      ChildrenEntity child = childrenRepository.findByLoginId(loginId);
          if(child == null){
            throw new UsernameNotFoundException("LoginIdNotFoundException");
          } else {
            return new ChildrenDetails(child);
          }
    } else {
      return new ParentDetails(parent);
    }
  }
}
