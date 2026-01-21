package it.medialogic.codice_fiscale.api;

import it.medialogic.codice_fiscale.generatore.dto.GeneratoreDto;
import it.medialogic.codice_fiscale.generatore.service.IGeneratoreService;
import it.medialogic.codice_fiscale.utils.Costanti;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Api che espone i servizi per la generazione dei codici fiscali.
 *
 * @author Lorenzo Ricci
 */
@RestController
@RequestMapping(Costanti.GENERATORE_API_PATH)
@RequiredArgsConstructor
public class GeneratoreApi {

    private final IGeneratoreService generatoreService;

    /**
     * Genera un codice fiscale da una lista prefissata
     *
     * @return Codice fiscale generato
     */
    @GetMapping
    public ResponseEntity<GeneratoreDto> generaCodiceFiscale() {
        return ResponseEntity.ok(generatoreService.generaCodiceFiscale());
    }
}
