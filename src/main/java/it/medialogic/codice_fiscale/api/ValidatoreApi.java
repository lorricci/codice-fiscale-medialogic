package it.medialogic.codice_fiscale.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.medialogic.codice_fiscale.exception.ExceptionHandlerConfig;
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
     *
     * @param codiceFiscale Codice Fiscale da validare
     * @return Dto contenente True se codice valido
     * @throws RestServiceException Errore di validazione del codice fiscale
     */
    @Operation(
            summary = "Validazione Codice Fiscale",
            description = "Effettua una validazione semplice sul codice fiscale"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Codice fiscale valido",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ValidatoreDto.class))
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
    public ResponseEntity<ValidatoreDto> validaCodiceFiscale(
            @Parameter(name = "codiceFiscale", description = "Il codice fiscale da validare")
            @RequestParam String codiceFiscale
    ) throws RestServiceException {
        return ResponseEntity.ok(validatoreService.validaCodiceFiscale(codiceFiscale));
    }
}
