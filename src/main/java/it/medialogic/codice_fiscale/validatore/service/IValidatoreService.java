package it.medialogic.codice_fiscale.validatore.service;

import it.medialogic.codice_fiscale.exception.RestServiceException;

/**
 * Servizio per la validazione dei codici fiscali
 *
 * @author Lorenzo Ricci
 */
public interface IValidatoreService {

    /**
     * Esegue dei controlli di validazione sul codice fiscale
     *
     * @param codiceFiscale Codice fiscale da validare
     * @throws RestServiceException Messaggio di errore della validazione
     */
    void validaCodiceFiscale(String codiceFiscale) throws RestServiceException;
}
