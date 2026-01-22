package it.medialogic.codice_fiscale.validatore.service;

import it.medialogic.codice_fiscale.exception.RestServiceException;
import it.medialogic.codice_fiscale.validatore.dto.ValidatoreDto;

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
     * @return Informazioni sulla validazione
     * @throws RestServiceException Messaggio di errore della validazione
     */
    ValidatoreDto validaCodiceFiscale(String codiceFiscale) throws RestServiceException;
}
