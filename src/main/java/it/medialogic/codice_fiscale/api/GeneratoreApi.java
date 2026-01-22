package it.medialogic.codice_fiscale.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.medialogic.codice_fiscale.exception.ExceptionHandlerConfig;
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
    @Operation(
            summary = "Generazione Codice Fiscale",
            description = "Restituisce un codice fiscale valido estratto da una lista predeterminata"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Codice fiscale generato con successo",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GeneratoreDto.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Errore interno del server",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionHandlerConfig.ExceptionDto.class))
            )
    })
    @GetMapping
    public ResponseEntity<GeneratoreDto> generaCodiceFiscale() {
        return ResponseEntity.ok(generatoreService.generaCodiceFiscale());
    }
}
