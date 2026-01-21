package it.medialogic.codice_fiscale.api;

import it.medialogic.codice_fiscale.estrattore.dto.EstrattoreDto;
import it.medialogic.codice_fiscale.estrattore.service.IEstrattoreService;
import it.medialogic.codice_fiscale.exception.RestServiceException;
import it.medialogic.codice_fiscale.utils.Costanti;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Api che espone i servizi per l'estrazione di informazioni dai codici fiscali.
 *
 * @author Lorenzo Ricci
 */
@RestController
@RequestMapping(Costanti.ESTRATTORE_API_PATH)
@RequiredArgsConstructor
public class EstrattoreApi {

    private final IEstrattoreService estrattoreService;

    @GetMapping
    public ResponseEntity<EstrattoreDto> estraiDataNascita(@RequestParam String codiceFiscale) throws RestServiceException {
        return ResponseEntity.ok(estrattoreService.estraiDataNascitaEta(codiceFiscale));
    }
}
