package ru.skypro.examgenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TooManyQuestionsException extends RuntimeException {

    public TooManyQuestionsException() {
        super("Запрошено больше вопросов, чем имеется.");
    }

}