package com.ecut.design.Repository;

import com.ecut.design.Model.Sign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignRepository extends JpaRepository<Sign,Long> {

}
