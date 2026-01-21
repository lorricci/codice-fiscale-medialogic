package it.medialogic.codice_fiscale;

import it.medialogic.codice_fiscale.generatore.dto.GeneratoreDto;
import it.medialogic.codice_fiscale.generatore.service.IGeneratoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/**
 * Classe di test per il servizio di generazione dei codici fiscali
 *
 * @author Lorenzo Ricci
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
@SpringBootTest
class GeneratoreServiceTest {

    private final IGeneratoreService generatoreService;

    @Test
    void testGenerazioneDaLista() {
        GeneratoreDto risultatoGeneratore = generatoreService.generaCodiceFiscale();
        Assert.notNull(risultatoGeneratore, "Il risultato della generazione del codice fiscale è null");
        String codiceFiscale = risultatoGeneratore.getCodiceFiscale();
        Assert.hasText(codiceFiscale, "Il codice fiscale è vuoto");
        log.info("Codice fiscale generato: {}", codiceFiscale);
    }
}
