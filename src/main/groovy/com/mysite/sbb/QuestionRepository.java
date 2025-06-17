package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

//    this method is just declared, but jpa automatically handles it
    Question findBySubject(String subject);
}
