package ru.skypro.examgenerator.service;

import org.springframework.stereotype.Service;
import ru.skypro.examgenerator.exception.TooManyQuestionsException;
import ru.skypro.examgenerator.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        Collection<Question> allQuestions = questionService.getAll();

        if (amount > allQuestions.size()) {
            throw new TooManyQuestionsException();
        }

        Set<Question> result = new HashSet<>();

        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }

        return result;
    }
}