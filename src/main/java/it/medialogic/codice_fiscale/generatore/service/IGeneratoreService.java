package it.medialogic.codice_fiscale.generatore.service;

import it.medialogic.codice_fiscale.generatore.dto.GeneratoreDto;

/**
 * Servizio per la generazione dei codici fiscali
 * @author Lorenzo Ricci
 */
public interface IGeneratoreService {

    /**
     * Genera un codice fiscale estraendolo casualmente da una lista prefissata
     * @return DTO contenente il codice fiscale generato
     */
    GeneratoreDto generaCodiceFiscale();
}
