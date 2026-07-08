package ru.skypro.examgenerator.repository;

import ru.skypro.examgenerator.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}