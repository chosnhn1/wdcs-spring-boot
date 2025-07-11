package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

//    this method is just declared, but jpa automatically handles it
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);

//    this is for search
    List<Question> findBySubjectLike(String subject);

//    for pagination
//    note: Spring Pagination starts with 0
    Page<Question> findAll(Pageable pageable);

//    for search
    Page<Question> findAll(Specification<Question> spec, Pageable pageable);

//    if you can write SQL query, this will work
//    note: use Entity name not table name, also do like q.author=u1 in column not q.author_id=u1.id
//    pass keyword with @Param and ref it with :keyword
    @Query("SELECT "
            + "DISTINCT q "
            + "FROM Question q "
            + "LEFT OUTER JOIN SiteUser u1 ON q.author=u1 "
            + "LEFT OUTER JOIN Answer a ON a.question=q "
            + "LEFT OUTER JOIN SiteUser u2 ON a.author=u2 "
            + "WHERE "
            + "q.subject LIKE %:kw% "
            + "OR q.content LIKE %:kw% "
            + "OR u1.username LIKE %:kw% "
            + "OR a.content LIKE %:kw% "
            + "OR u2.username LIKE %:kw% ")
    Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable);

}
