package com.projectteam3.recipeproject.app.gen.exception;

import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import com.projectteam3.recipeproject.app.gen.dto.ResponseInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        Integer code = HttpStatus.NOT_FOUND.value();
        String message = exception.getMessage() + " (" + request.getDescription(false) + ")";
        ResponseInfo info = ResponseInfo.error(code, message);

        BaseResponseDto baseResponseDto = new BaseResponseDto(info, null);
        return new ResponseEntity(baseResponseDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity handleResourceUsedException(ResourceUsedException exception, WebRequest request) {
        Integer code = HttpStatus.BAD_REQUEST.value();
        String message = exception.getMessage() + " (" + request.getDescription(false) + ")";
        ResponseInfo info = ResponseInfo.error(code, message);

        BaseResponseDto baseResponseDto = new BaseResponseDto(info, null);
        return new ResponseEntity(baseResponseDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, WebRequest request) {
        Integer code = HttpStatus.BAD_REQUEST.value();
        String message = "";
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            message += fieldError.getField()+": "+ fieldError.getDefaultMessage() + "; ";
        }

        ResponseInfo info = ResponseInfo.error(code, message);

        BaseResponseDto baseResponseDto = new BaseResponseDto(info, null);
        return new ResponseEntity(baseResponseDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity handleAllException(Exception exception, WebRequest request) {
        Integer code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String message = exception.getMessage()+ " (" + request.getDescription(false) + ")";
        ResponseInfo info = ResponseInfo.error(code, message);

        BaseResponseDto baseResponseDto = new BaseResponseDto(info, null);
        return new ResponseEntity(baseResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
