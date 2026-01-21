package it.medialogic.codice_fiscale.estrattore.service;

import it.medialogic.codice_fiscale.estrattore.dto.EstrattoreDto;
import it.medialogic.codice_fiscale.exception.RestServiceException;

/**
 * Servizio per l'estrazione di dati dai codici fiscali
 *
 * @author Lorenzo Ricci
 */
public interface IEstrattoreService {

    /**
     * Estrae la data di nascita e l'età ricavate dal codice fiscale
     *
     * @param codiceFiscale Codice Fiscale da cui estratte la data di nascita e l'età
     * @return Dto con data di nascita ed età
     * @throws RestServiceException Errore di validazione del codice fiscale
     */
    EstrattoreDto estraiDataNascitaEta(String codiceFiscale) throws RestServiceException;
}
