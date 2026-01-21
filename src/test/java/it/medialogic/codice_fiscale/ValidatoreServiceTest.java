package it.medialogic.codice_fiscale;

import it.medialogic.codice_fiscale.exception.RestServiceException;
import it.medialogic.codice_fiscale.generatore.service.IGeneratoreService;
import it.medialogic.codice_fiscale.validatore.service.IValidatoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Classe di test per il servizio di validazione dei codici fiscali
 *
 * @author Lorenzo Ricci
 */
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
class ValidatoreServiceTest {

    private final IValidatoreService validatoreService;
    private final IGeneratoreService generatoreService;

    private final String messaggioNumeroCaratteri = "Il codice fiscale deve contenere esattamente 16 caratteri.";

    @Test
    void testCodiceFiscaleNull() {
        RestServiceException ex = Assertions.assertThrows(RestServiceException.class, () -> validatoreService.validaCodiceFiscale(null));
        Assertions.assertEquals(messaggioNumeroCaratteri, ex.getMessage());
        log.info("Eccezione lanciata correttamente per cf null: {}", ex.getMessage());
    }

    @Test
    void testCodiceFiscaleNumeroCaratteri() {
        String codiceFiscale = "XXXXXX";
        RestServiceException ex = Assertions.assertThrows(RestServiceException.class, () -> validatoreService.validaCodiceFiscale(codiceFiscale));
        Assertions.assertEquals(messaggioNumeroCaratteri, ex.getMessage());
        log.info("Eccezione lanciata correttamente per cf con lunghezza diversa da 16 caratteri: {}", ex.getMessage());
    }

    @Test
    void testCodiceFiscaleGeneratoDaLista() {
        // Assumiamo che il codice fiscale venga generato correttamente secondo i test in GeneratoreServiceTest
        String codiceFiscale = generatoreService.generaCodiceFiscale().getCodiceFiscale();
        Assertions.assertDoesNotThrow(() -> validatoreService.validaCodiceFiscale(codiceFiscale));
        log.info("Codice fiscale validato: {}", codiceFiscale);
    }

}
