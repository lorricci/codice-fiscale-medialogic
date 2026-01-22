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

    @Test
    void testEstrazioneCfNonValido() {
        // Verifichiamo semplicemente che lanci l'eccezione. I test di validazione avvengono in ValidatoreServiceTest
        String codiceFiscale = "XXXXXXX";
        Assertions.assertThrows(RestServiceException.class, () -> estrattoreService.estraiDataNascitaEta(codiceFiscale));
        log.info("La validazione ferma l'esecuzione in maniera corretta per codice fiscale {}", codiceFiscale);
    }

    @Test
    void testEstrazioneDaCodiceFiscaleLista_01() {
        // Setup CF e data di nascita
        String codiceFiscale = "MROSSI80A01H501U";
        LocalDate dataNascita = LocalDate.of(1980, 1, 1);
        log.info("Data di nascita da verificare: 01/01/1980");
        // Setup differenza ed estrazione
        Period differenza = Period.between(dataNascita, LocalDate.now());
        EstrattoreDto dati = Assertions.assertDoesNotThrow(() -> estrattoreService.estraiDataNascitaEta(codiceFiscale));
        // Assertions
        eseguiAssertions(dati, dataNascita, differenza);
    }

    @Test
    void testEstrazioneDaCodiceFiscaleLista_02() {
        // Setup CF e data di nascita
        String codiceFiscale = "BNCGNN95E15L219O";
        LocalDate dataNascita = LocalDate.of(1995, 5, 15);
        log.info("Data di nascita da verificare: 15/05/1995");
        // Setup differenza ed estrazione
        Period differenza = Period.between(dataNascita, LocalDate.now());
        EstrattoreDto dati = Assertions.assertDoesNotThrow(() -> estrattoreService.estraiDataNascitaEta(codiceFiscale));
        // Assertions
        eseguiAssertions(dati, dataNascita, differenza);
    }

    @Test
    void testEstrazioneDaCodiceFiscaleLista_03() {
        // Setup CF e data di nascita
        String codiceFiscale = "RCCLNZ06H04H501U";
        LocalDate dataNascita = LocalDate.of(2006, 6, 4);
        log.info("Data di nascita da verificare: 04/06/2006");
        // Setup differenza ed estrazione
        Period differenza = Period.between(dataNascita, LocalDate.now());
        EstrattoreDto dati = Assertions.assertDoesNotThrow(() -> estrattoreService.estraiDataNascitaEta(codiceFiscale));
        // Assertions
        eseguiAssertions(dati, dataNascita, differenza);
    }

    /**
     * Esegue i test su data di nascita ed età
     */
    private void eseguiAssertions(EstrattoreDto dati, LocalDate dataNascita, Period differenza) {
        Assertions.assertEquals(dati.getDataNascita(), dataNascita);
        log.info("Data di nascita corretta.");
        Assertions.assertEquals(dati.getEta().getAnni(), differenza.getYears());
        Assertions.assertEquals(dati.getEta().getMesi(), differenza.getMonths());
        Assertions.assertEquals(dati.getEta().getGiorni(), differenza.getDays());
        log.info("L'età è corretta.");
    }
}
