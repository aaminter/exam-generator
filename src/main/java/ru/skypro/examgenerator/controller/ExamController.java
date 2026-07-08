package ru.skypro.examgenerator.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.examgenerator.model.Question;
import ru.skypro.examgenerator.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}