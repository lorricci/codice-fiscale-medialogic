package it.medialogic.codice_fiscale.estrattore.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Rappresenta in maniera dettagliata l'età di un soggetto indicando separatamente anni, mesi e giorni
 *
 * @author Lorenzo Ricci
 */
@Data
@Builder
public class EtaDto {

    private Integer anni;
    private Integer mesi;
    private Integer giorni;
}
