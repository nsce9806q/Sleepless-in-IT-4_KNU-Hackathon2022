package sleeplessinit4.hanzip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sleeplessinit4.hanzip.entity.ActivityEntity;

import java.util.List;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {

    @Query("select a from activity a where a.house.houseId = :houseId")
    List<ActivityEntity> findByHouseId(@Param("houseId") Long houseId);
}
