package it.medialogic.codice_fiscale.generatore.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Risultato della generazione di un codice fiscale valido
 *
 * @author Lorenzo Ricci
 */
@Data
@Builder
public class GeneratoreDto {

    private String codiceFiscale;
}
