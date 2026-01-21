package it.medialogic.codice_fiscale;


import it.medialogic.codice_fiscale.estrattore.dto.EstrattoreDto;
import it.medialogic.codice_fiscale.estrattore.service.IEstrattoreService;
import it.medialogic.codice_fiscale.exception.RestServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Period;

/**
 * Classe di test per il servizio di estrazione dati dai codici fiscali
 *
 * @author Lorenzo Ricci
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
@SpringBootTest
class EstrattoreServiceTest {

    private final IEstrattoreService estrattoreService;

    private final String etaDaVerificareMessage = "Età da verificare: {}";
    private final String annoCorrettoMessage = "Anno di nascita corretto.";
    private final String etaCorrettaMessage = "Età corretta.";

    @Test
    void testEstrazioneCfNonValido() {
        // Verifichiamo semplicemente che lanci l'eccezione. I test di validazione avvengono in ValidatoreServiceTest
        String codiceFiscale = "XXXXXXX";
        Assertions.assertThrows(RestServiceException.class, () -> estrattoreService.estraiDataNascitaEta(codiceFiscale));
        log.info("La validazione ferma l'esecuzione in maniera corretta per codice fiscale {}", codiceFiscale);
    }

    @Test
    void testEstrazioneDaCodiceFiscaleLista_01() {
        String codiceFiscale = "MROSSI80A01H501U";
        LocalDate dataNascita = LocalDate.of(1980, 1, 1);
        log.info("Data di nascita da verificare: 01/01/1980");
        Integer eta = Period.between(dataNascita, LocalDate.now()).getYears();
        log.info(etaDaVerificareMessage, eta);
        EstrattoreDto dati = Assertions.assertDoesNotThrow(() -> estrattoreService.estraiDataNascitaEta(codiceFiscale));
        Assertions.assertEquals(dati.getDataNascita(), dataNascita);
        log.info(annoCorrettoMessage);
        Assertions.assertEquals(dati.getEta(), eta);
        log.info(etaCorrettaMessage);
    }

    @Test
    void testEstrazioneDaCodiceFiscaleLista_02() {
        String codiceFiscale = "BNCGNN95E15L219O";
        LocalDate dataNascita = LocalDate.of(1995, 5, 15);
        log.info("Data di nascita da verificare: 15/05/1995");
        Integer eta = Period.between(dataNascita, LocalDate.now()).getYears();
        log.info(etaDaVerificareMessage, eta);
        EstrattoreDto dati = Assertions.assertDoesNotThrow(() -> estrattoreService.estraiDataNascitaEta(codiceFiscale));
        Assertions.assertEquals(dati.getDataNascita(), dataNascita);
        log.info(annoCorrettoMessage);
        Assertions.assertEquals(dati.getEta(), eta);
        log.info(etaCorrettaMessage);
    }

    @Test
    void testEstrazioneDaCodiceFiscaleLista_03() {
        String codiceFiscale = "RCCLNZ06H04H501U";
        LocalDate dataNascita = LocalDate.of(2006, 6, 4);
        log.info("Data di nascita da verificare: 04/06/2006");
        Integer eta = Period.between(dataNascita, LocalDate.now()).getYears();
        log.info(etaDaVerificareMessage, eta);
        EstrattoreDto dati = Assertions.assertDoesNotThrow(() -> estrattoreService.estraiDataNascitaEta(codiceFiscale));
        Assertions.assertEquals(dati.getDataNascita(), dataNascita);
        log.info(annoCorrettoMessage);
        Assertions.assertEquals(dati.getEta(), eta);
        log.info(etaCorrettaMessage);
    }
}
