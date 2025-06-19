package com.mysite.sbb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

//    this method is just declared, but jpa automatically handles it
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);

//    this is for search
    List<Question> findBySubjectLike(String subject);
}
