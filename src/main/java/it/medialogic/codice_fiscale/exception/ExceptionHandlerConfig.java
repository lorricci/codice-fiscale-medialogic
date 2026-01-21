package it.medialogic.codice_fiscale.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Gestore delle eccezioni lanciate dall'applicazione
 *
 * @author Lorenzo Ricci
 */
@ControllerAdvice
public class ExceptionHandlerConfig extends ResponseEntityExceptionHandler {

    @Data
    @Builder
    public static class ExceptionDto {
        private String message;
    }

    /**
     * Gestisce le RestServiceException restituendo una risposta REST con codice e messaggio indicati dall'eccezione
     *
     * @param ex Eccezione lanciata
     * @return Risposta contenente informazioni sull'errore
     */
    @ExceptionHandler(RestServiceException.class)
    public final ResponseEntity<ExceptionDto> handleRestServiceException(RestServiceException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(ExceptionDto.builder().message(ex.getMessage()).build());
    }

    /**
     * Gestisce una Exception generica restituendo una risposta REST con codice 500 e messaggio indicato dall'eccezione
     *
     * @param ex Eccezione lanciata
     * @return Risposta contenente informazioni sull'errore
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionDto> handleGenericException(RestServiceException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ExceptionDto.builder().message(ex.getMessage()).build());
    }
}

