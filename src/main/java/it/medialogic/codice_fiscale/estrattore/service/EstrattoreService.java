package it.medialogic.codice_fiscale.estrattore.service;

import it.medialogic.codice_fiscale.estrattore.dto.EstrattoreDto;
import it.medialogic.codice_fiscale.estrattore.dto.EtaDto;
import it.medialogic.codice_fiscale.exception.RestServiceException;
import it.medialogic.codice_fiscale.validatore.service.IValidatoreService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EstrattoreService implements IEstrattoreService {

    private final IValidatoreService validatoreService;
    private Map<String, Integer> mesiCf;

    @PostConstruct
    private void inizializzaMappaCf() {
        mesiCf = HashMap.newHashMap(12);
        mesiCf.put("A", 1); // Gennaio
        mesiCf.put("B", 2); // Febbraio
        mesiCf.put("C", 3); // Marzo
        mesiCf.put("D", 4); // Aprile
        mesiCf.put("E", 5); // Maggio
        mesiCf.put("H", 6); // Giugno
        mesiCf.put("L", 7); // Luglio
        mesiCf.put("M", 8); // Agosto
        mesiCf.put("P", 9); // Settembre
        mesiCf.put("R", 10); // Ottobre
        mesiCf.put("S", 11); // Novembre
        mesiCf.put("T", 12); // Dicembre
    }

    @Override
    public EstrattoreDto estraiDataNascitaEta(String codiceFiscale) throws RestServiceException {
        // Validiamo prima il codice fiscale
        validatoreService.validaCodiceFiscale(codiceFiscale);
        // Estraiamo la parte del CF che indica la data di nascita - caratteri 6 - 10
        String dataNascita = codiceFiscale.substring(6, 11);
        // Estraiamo la data
        LocalDate data = LocalDate.of(
                estraiAnnoDaDataNascita(dataNascita),
                estraiMeseDaDataNascita(dataNascita),
                estraiGiornoDaDataNascita(dataNascita)
        );
        // Costruisce la risposta
        Period differenza = Period.between(data, LocalDate.now());
        return EstrattoreDto.builder()
                .dataNascita(data)
                .eta(EtaDto.builder()
                        .giorni(differenza.getDays())
                        .mesi(differenza.getMonths())
                        .anni(differenza.getYears())
                        .build()
                )
                .build();
    }

    /**
     * Estrae l'anno di nascita dalla data di nascita.
     * Si calcola assumendo che se le cifre dell'anno nel CF sono maggiori delle ultime due cifre dell'anno corrente
     * allora l'anno è nel 1900, altrimenti nel 2000.
     *
     * @param dataNascita Porzione del codice fiscale contenente la data di nascita
     * @return Anno di nascita
     */
    private Integer estraiAnnoDaDataNascita(String dataNascita) {
        int cifreAnnoCorrente = LocalDate.now().getYear() % 100; // Prendiamo le ultime due cifre
        int annoCf = Integer.parseInt(dataNascita.substring(0, 2));
        return annoCf > cifreAnnoCorrente ? 1900 + annoCf : 2000 + annoCf;
    }

    /**
     * Estra il numero del mese dalla data di nascita
     *
     * @param dataNascita Porzione del codice fiscale contenente la data di nascita
     * @return Numero del mese
     */
    private Integer estraiMeseDaDataNascita(String dataNascita) {
        return mesiCf.get(dataNascita.substring(2, 3));
    }

    /**
     * Estrai il giorno dalla data di nascita
     *
     * @param dataNascita Porzione del codice fiscale contenente la data di nascita
     * @return Giorno di nascita
     */
    private Integer estraiGiornoDaDataNascita(String dataNascita) {
        int giorno = Integer.parseInt(dataNascita.substring(3));
        return giorno > 40 ? giorno - 40 : giorno;
    }
}
