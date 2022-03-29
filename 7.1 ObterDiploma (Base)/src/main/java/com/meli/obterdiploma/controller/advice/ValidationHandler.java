package com.meli.obterdiploma.controller.advice;


import com.meli.obterdiploma.model.ValidationErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice
public class ValidationHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<List<ValidationErrorDTO>> handleValidationException(MethodArgumentNotValidException ex) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        List<ValidationErrorDTO> errorsDTO = new ArrayList<>();
        errors.forEach(err -> {
            ValidationErrorDTO error = new ValidationErrorDTO(
                    "valor inválido para o campo",
                    err.getDefaultMessage());

            errorsDTO.add(error);
        });
        return new ResponseEntity<>(errorsDTO, HttpStatus.BAD_REQUEST);
    }
}
