package it.medialogic.codice_fiscale.validatore.service;

import it.medialogic.codice_fiscale.exception.RestServiceException;
import it.medialogic.codice_fiscale.validatore.dto.ValidatoreDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ValidatoreService implements IValidatoreService {

    private static final String REGEX_VALIDAZIONE_CF = "^(?:[A-Z][AEIOUX][AEIOUX]|[B-DF-HJ-NP-TV-Z]{2}[A-Z]){2}(?:[\\dLMNP-V]{2}(?:[A-EHLMPR-T](?:[04LQ][1-9MNP-V]|[15MR][\\dLMNP-V]|[26NS][0-8LMNP-U])|[DHPS][37PT][0L]|[ACELMRT][37PT][01LM]|[AC-EHLMPR-T][26NS][9V])|(?:[02468LNQSU][048LQU]|[13579MPRTV][26NS])B[26NS][9V])(?:[A-MZ][1-9MNP-V][\\dLMNP-V]{2}|[A-M][0L](?:[1-9MNP-V][\\dLMNP-V]|[0L][1-9MNP-V]))[A-Z]$";

    @Override
    public ValidatoreDto validaCodiceFiscale(String codiceFiscale) throws RestServiceException {
        if (!StringUtils.hasText(codiceFiscale) || codiceFiscale.length() != 16) {
            throw new RestServiceException("Il codice fiscale deve contenere esattamente 16 caratteri.", HttpStatus.BAD_REQUEST);
        }
        if (!codiceFiscale.matches(REGEX_VALIDAZIONE_CF)) {
            throw new RestServiceException("Il codice fiscale inserito non è valido.", HttpStatus.BAD_REQUEST);
        }
        return ValidatoreDto.builder().valido(Boolean.TRUE).messaggio("Il codice fiscale " + codiceFiscale + " è valido").build();
    }
}
