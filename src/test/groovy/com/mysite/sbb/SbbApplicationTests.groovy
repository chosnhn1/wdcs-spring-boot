package com.mysite.sbb

//import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {

		Question q = this.questionRepository.findBySubject("What is sbb?");
		assertEquals(1, q.getId());

//		Test #3: search q by id and check subject

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
