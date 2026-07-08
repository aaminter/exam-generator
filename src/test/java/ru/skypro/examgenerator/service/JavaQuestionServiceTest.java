package ru.skypro.examgenerator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.examgenerator.model.Question;
import ru.skypro.examgenerator.repository.QuestionRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private JavaQuestionService service;

    @Test
    void addShouldReturnAddedQuestion() {

        Question expected = new Question("Q1", "A1");

        when(repository.add(any(Question.class))).thenReturn(expected);

        Question actual = service.add("Q1", "A1");

        assertEquals(expected, actual);

        verify(repository).add(new Question("Q1", "A1"));
    }

    @Test
    void removeShouldReturnRemovedQuestion() {

        Question expected = new Question("Q1", "A1");

        when(repository.remove(any(Question.class))).thenReturn(expected);

        Question actual = service.remove("Q1", "A1");

        assertEquals(expected, actual);

        verify(repository).remove(new Question("Q1", "A1"));
    }

    @Test
    void getAllShouldReturnAllQuestions() {

        List<Question> expected = List.of(
                new Question("Q1", "A1"),
                new Question("Q2", "A2")
        );

        when(repository.getAll()).thenReturn(expected);

        assertEquals(expected, service.getAll());

        verify(repository).getAll();
    }

    @Test
    void getRandomQuestionShouldReturnExistingQuestion() {

        Question question = new Question("Q1", "A1");

        when(repository.getAll()).thenReturn(List.of(question));

        Question actual = service.getRandomQuestion();

        assertEquals(question, actual);
    }

}