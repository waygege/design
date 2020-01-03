package com.ecut.design.Repository;

import com.ecut.design.Model.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitoryTypeRepository extends JpaRepository<ActivityType,Long> {
}
