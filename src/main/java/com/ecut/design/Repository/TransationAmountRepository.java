package com.ecut.design.Repository;

import com.ecut.design.Model.TransationAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransationAmountRepository extends JpaRepository<TransationAmount,Long> {

}
