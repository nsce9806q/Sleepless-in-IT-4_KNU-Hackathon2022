package sleeplessinit4.hanzip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sleeplessinit4.hanzip.entity.ChildrenEntity;
import sleeplessinit4.hanzip.entity.ParentEntity;

public interface ParentRepository extends JpaRepository<ParentEntity, Long> {

    @Query("select p from parent p join fetch p.parentMissionList")
    public ParentEntity findParentWithMissionById(Long parentId);
}
