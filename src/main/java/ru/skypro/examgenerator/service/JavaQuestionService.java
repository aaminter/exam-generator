package ru.skypro.examgenerator.service;

import org.springframework.stereotype.Service;
import ru.skypro.examgenerator.model.Question;
import ru.skypro.examgenerator.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository repository;
    private final Random random = new Random();

    public JavaQuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(String question, String answer) {
        return repository.remove(new Question(question, answer));
    }

    @Override
    public Question remove(Question question) {
        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {

        List<Question> questions = new ArrayList<>(repository.getAll());

        if (questions.isEmpty()) {
            throw new IllegalStateException("Список вопросов пуст.");
        }

        return questions.get(random.nextInt(questions.size()));
    }
}