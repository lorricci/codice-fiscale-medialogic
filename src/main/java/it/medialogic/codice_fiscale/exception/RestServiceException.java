package it.medialogic.codice_fiscale.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Eccezione utilizzata per wrappare i messaggi di eccezione insieme al codice di errore da mandare in risposta nelle Api
 *
 * @author Lorenzo Ricci
 */
@Getter
@Setter
public class RestServiceException extends Exception {

    private final HttpStatus httpStatus;

    public RestServiceException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public RestServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
