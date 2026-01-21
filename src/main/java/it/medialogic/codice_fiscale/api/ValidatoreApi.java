package it.medialogic.codice_fiscale.api;

import it.medialogic.codice_fiscale.exception.RestServiceException;
import it.medialogic.codice_fiscale.utils.Costanti;
import it.medialogic.codice_fiscale.validatore.dto.ValidatoreDto;
import it.medialogic.codice_fiscale.validatore.service.IValidatoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Api che espone i servizi per la validazione dei codici fiscali.
 *
 * @author Lorenzo Ricci
 */
@RestController
@RequestMapping(Costanti.VALIDATORE_API_PATH)
@RequiredArgsConstructor
public class ValidatoreApi {

    private final IValidatoreService validatoreService;

    /**
     * Valida il codice fiscale indicato
     * @param codiceFiscale Codice Fiscale da validare
     * @return Dto contenente True se codice valido
     * @throws RestServiceException Errore di validazione del codice fiscale
     */
    @GetMapping
    public ResponseEntity<ValidatoreDto> validaCodiceFiscale(@RequestParam String codiceFiscale) throws RestServiceException {
        validatoreService.validaCodiceFiscale(codiceFiscale);
        return ResponseEntity.ok(ValidatoreDto.builder().valido(Boolean.TRUE).build());
    }
}
