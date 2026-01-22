package it.medialogic.codice_fiscale.estrattore.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * Risultato dell'estrazione dati da un codice fiscale
 *
 * @author Lorenzo Ricci
 */
@Data
@Builder
public class EstrattoreDto {

    private LocalDate dataNascita;
    private EtaDto eta;
}
