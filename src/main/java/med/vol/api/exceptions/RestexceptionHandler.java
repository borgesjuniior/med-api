package med.vol.api.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class RestexceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<Void> notFoundHandler() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity badRequestHanlder(MethodArgumentNotValidException exception) {
    var errors = exception.getFieldErrors();

    return ResponseEntity.badRequest().body(errors.stream().map(ExceptionHandlerDTO::new).toList());
  }

  private record ExceptionHandlerDTO(String field, String message) {
    public ExceptionHandlerDTO(FieldError err) {
      this(err.getField(), err.getDefaultMessage());
    }
  }
}
