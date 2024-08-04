package com.example.playlistproject.exception;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    // GET, PUT, DELETE에서 호출한 id 값에 해당하는 데이터가 없을때
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandler(IllegalArgumentException e) {
        return new ErrorResult("BAD_INPUT", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResult methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ErrorResult(e.getDetailMessageCode(), e.getMessage());
    }

    // PostMapping에서 필수 데이터가 누락 되었을때
    // artist, song 둘 중 하나라도 누락된 경우
    @ExceptionHandler(PropertyValueException.class)
    public ErrorResult propertyValueException(PropertyValueException e) {
        return new ErrorResult("Missing value (artist or song)", e.getMessage());
    }

}
