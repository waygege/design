package com.ecut.design.Repository;

import com.ecut.design.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from question where id in (:ids)",nativeQuery = true)
    public void deleteQuestionByids(Long[] ids);
}
