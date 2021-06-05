package ro.fasttrackit.tema12.course.service.controller.exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException(String msg) {
        super(msg);
    }
}
