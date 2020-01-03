package com.ecut.design.Repository;

import com.ecut.design.Model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {

    @Query(value = "select a* ,o.title,o.attributed,o.attributec,o.attributeb,o.attributea from activity a  left join  options o on a.id=o.activity_id where a.id=?1" ,nativeQuery = true)
    public Activity findActivityById(Long id);
}
