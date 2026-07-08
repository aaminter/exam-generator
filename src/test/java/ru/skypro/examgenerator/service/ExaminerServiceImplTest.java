package ru.skypro.examgenerator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.examgenerator.exception.TooManyQuestionsException;
import ru.skypro.examgenerator.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestionsShouldReturnRequestedAmount() {

        Question q1 = new Question("Q1", "A1");
        Question q2 = new Question("Q2", "A2");

        when(questionService.getAll()).thenReturn(List.of(q1, q2));
        when(questionService.getRandomQuestion())
                .thenReturn(q1)
                .thenReturn(q2);

        assertEquals(2, examinerService.getQuestions(2).size());
    }

    @Test
    void shouldThrowExceptionWhenTooManyQuestionsRequested() {

        when(questionService.getAll()).thenReturn(List.of(
                new Question("Q1", "A1")
        ));

        assertThrows(
                TooManyQuestionsException.class,
                () -> examinerService.getQuestions(2)
        );
    }

    @Test
    void returnedQuestionsShouldBeUnique() {

        Question q1 = new Question("Q1", "A1");
        Question q2 = new Question("Q2", "A2");

        when(questionService.getAll()).thenReturn(List.of(q1, q2));

        when(questionService.getRandomQuestion())
                .thenReturn(q1)
                .thenReturn(q1)
                .thenReturn(q2);

        assertEquals(2, examinerService.getQuestions(2).size());
    }

}