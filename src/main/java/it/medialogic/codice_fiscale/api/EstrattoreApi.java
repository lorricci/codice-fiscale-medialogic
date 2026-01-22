package it.medialogic.codice_fiscale.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.medialogic.codice_fiscale.estrattore.dto.EstrattoreDto;
import it.medialogic.codice_fiscale.estrattore.service.IEstrattoreService;
import it.medialogic.codice_fiscale.exception.ExceptionHandlerConfig;
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

    /**
     * Estrae la data di nascita e l'età dal codice fiscale indicato
     *
     * @param codiceFiscale Codice fiscale
     * @return Dto contenente data di nascita ed età
     * @throws RestServiceException Errore di validazione del codice fiscale
     */
    @Operation(
            summary = "Estrazione Data Di Nascita ed Età",
            description = "Restituisce un DTO contenente la data di nascita e l'età associati al codice fiscale indicato"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Dati estratti con successo",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EstrattoreDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Errore di validazione del codice fiscale",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionHandlerConfig.ExceptionDto.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Errore interno del server",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionHandlerConfig.ExceptionDto.class))
            )
    })
    @GetMapping
    public ResponseEntity<EstrattoreDto> estraiDataNascita(
            @Parameter(name = "codiceFiscale", description = "Il codice fiscale da cui estratte data di nascita ed età")
            @RequestParam String codiceFiscale
    ) throws RestServiceException {
        return ResponseEntity.ok(estrattoreService.estraiDataNascitaEta(codiceFiscale));
    }
}
