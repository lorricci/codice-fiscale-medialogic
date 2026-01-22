package it.medialogic.codice_fiscale.validatore.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Dati sulla validazione di un codice fiscale
 *
 * @author Lorenzo Ricci
 */
@Data
@Builder
public class ValidatoreDto {

    private Boolean valido;
    private String messaggio;
}
