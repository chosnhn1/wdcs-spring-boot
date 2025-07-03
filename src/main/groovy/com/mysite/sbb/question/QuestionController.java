package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

// for url prefix
import lombok.RequiredArgsConstructor;

import com.mysite.sbb.answer.AnswerForm;

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
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<Question> paging = this.questionService.getList(page);
//        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("paging", paging);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

//    method overloading: same method name, different arg const
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
//      note that @Valid arg should be followed by BindingResult arg
//      add validation
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list"; // redirect q list after post
    }
}
