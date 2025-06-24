package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// for url prefix

import lombok.RequiredArgsConstructor;

// the lombok annotation will make constructor for final qRepo.
// RequestMapping annotation will set url prefix
@RequiredArgsConstructor
@RequestMapping("/question")
@Controller
public class QuestionController {

//    the code below is using repository directly; will be replaced with service
//    private final QuestionRepository questionRepository;

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
//        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate() {
        return "question_form";
    }

//    method overloading: same method name, different arg const
    @PostMapping("/create")
    public String questionCreate(@RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
        this.questionService.create(subject, content);
        return "redirect:/question/list"; // redirect q list after post
    }
}
