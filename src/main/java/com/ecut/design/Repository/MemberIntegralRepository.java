package com.ecut.design.Repository;

import com.ecut.design.Model.MemberIntegral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberIntegralRepository extends JpaRepository<MemberIntegral,Long> {
}
