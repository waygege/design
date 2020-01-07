package com.ecut.design.Repository;

import com.ecut.design.Model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long>  {


}
