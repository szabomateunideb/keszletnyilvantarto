package hu.unideb.inf.keszletnyilvantarto.controller.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler
        extends ResponseEntityExceptionHandler {

    public record fieldViolation(String field, String message){}

    private ProblemDetail problem(HttpStatus status
            , String type
            , String title
            , String detail){

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(status, detail);
        problem.setTitle(title);
        problem.setProperty("errors", List.of());
        return problem;
    }
}
