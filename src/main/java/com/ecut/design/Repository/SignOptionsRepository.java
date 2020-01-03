package com.ecut.design.Repository;

import com.ecut.design.Model.Sign;
import com.ecut.design.Model.SignOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignOptionsRepository extends JpaRepository<Sign,Long> {

    @Query(value = "select * from sign_options where signId=:id",nativeQuery = true)
     List<SignOptions> findSignOptionsBySignId(Long id);
}
