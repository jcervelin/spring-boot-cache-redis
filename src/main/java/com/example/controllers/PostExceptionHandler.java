package com.example.controllers;

import com.example.exceptions.PostNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class PostExceptionHandler {

    private Logger log = LoggerFactory.getLogger(PostExceptionHandler.class);

/*    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Post Not Found")
    @ExceptionHandler(PostNotFoundException.class)
    public void handlePostNotFound(HttpServletRequest request, Exception ex) {
        log.error("{} : {}", ex.getMessage(), request.getRequestURI());
    }*/

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Post Not Found")
    @ExceptionHandler(PostNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleForbiddenResourceException(HttpServletRequest request, PostNotFoundException ex) {
        log.error("{} : {}", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }
}
