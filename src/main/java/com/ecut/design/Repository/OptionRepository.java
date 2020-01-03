package com.ecut.design.Repository;

import com.ecut.design.Model.Options;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Options,Long> {

   @Query(value = "delete options where  activity_id=:?1",nativeQuery = true)
    public String deleteByActivityId(Long id);


}
