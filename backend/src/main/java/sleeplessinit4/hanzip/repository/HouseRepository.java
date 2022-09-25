package sleeplessinit4.hanzip.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sleeplessinit4.hanzip.entity.ChildrenEntity;
import sleeplessinit4.hanzip.entity.HouseEntity;

public interface HouseRepository extends JpaRepository<HouseEntity, Long> {

    @Query("select h from house h where h.parent.parentId = :parentId")
    public HouseEntity findByParentId(@Param("parentId") Long parentId);

    @Query("select h from house h where h.children.childrenId = :childrenId")
    public HouseEntity findByChildrenId(@Param("childrenId") Long childrenId);

    Optional<HouseEntity> findByRandomCode(String randomCode);
}
