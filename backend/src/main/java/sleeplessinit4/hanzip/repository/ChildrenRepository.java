package sleeplessinit4.hanzip.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sleeplessinit4.hanzip.entity.ChildrenEntity;

public interface ChildrenRepository extends JpaRepository<ChildrenEntity, Long> {

    @Query("select c from children c join fetch c.childrenMissionList")
    public ChildrenEntity findChildrenWithMissionById(Long childrenId);

    ChildrenEntity findByLoginId(String loginId);
}
