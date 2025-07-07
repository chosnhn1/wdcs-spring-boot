package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerRepository answerRepository;

	@Transactional
	@Test
	void testJpa() {

// 		Test for Paging: add many testcases;
		for (int i = 1; i <= 300; i++) {
			String subject = String.format("This is a test q:[%03d]", i);
			String content = "which has no contents";
			this.questionService.create(subject, content, null);
		}

//		Test #11: get answers from a question
		// Optional<Question> oq = this.questionRepository.findById(2);
		// assertTrue(oq.isPresent());
		// Question q = oq.get();

//		the code below will get a failed test, because it had no session
//		to do this test, @Transactional annotation will be required.
		// List<Answer> answerList = q.getAnswerList();
		// assertEquals(1, answerList.size());
		// assertEquals("Yes, it is created automatically.", answerList.get(0).getContent());

//		Test #10: find answer with id
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());

//		Test #9: create an answer
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		Answer a = new Answer();
//		a.setContent("Yes, it is created automatically.");
//		a.setQuestion(q);
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);


//		Test #8: delete question

//		assertEquals(2, this.questionRepository.count());			// count method of Repository returns data row count
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count());			// check one of two is deleted

//		Test #7: modify question

//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("modified title");
//		this.questionRepository.save(q);

//		Test #6: LIKE search with subject

//		List<Question> qList = this.questionRepository.findBySubjectLike("%sbb%");
//		Question q = qList.get(0);
//		assertEquals("What is sbb?", q.getSubject());

//		Test #5: find with both subject and content

//		Question q = this.questionRepository.findBySubjectAndContent("What is sbb?", "Please give me some answer!");
//		assertEquals(1, q.getId())

//		Test #4: find with subject

//		Question q = this.questionRepository.findBySubject("What is sbb?");
//		assertEquals(1, q.getId());

//		Test #3: find q by id and check subject

//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("What is sbb?", q.getSubject());
//		}

//		Test #2: check two qs

//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//
//		Question q = all.get(0);
//		assertEquals("What is sbb?", q.getSubject())

//		Test #1: make two qs

//		Question q1 = new Question();
//		q1.setSubject("What is sbb?");
//		q1.setContent("Please give me some answer!");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);
//
//		Question q2 = new Question();
//		q2.setSubject("q about spring boot model");
//		q2.setContent("is id automatically set?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
	}

	@Test
	void contextLoads() {
	}

}
