package it.medialogic.codice_fiscale.generatore.service;

import it.medialogic.codice_fiscale.generatore.dto.GeneratoreDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class GeneratoreService implements IGeneratoreService {

    private final List<String> codiciFiscali = List.of(
            "MROSSI80A01H501U",
            "BNCGNN95E15L219O",
            "VRELCU72T20F205B",
            "FRRMRC88R45H501C",
            "RSSMRA90B28A944E"
    );
    private final Random random = new Random();

    @Override
    public GeneratoreDto generaCodiceFiscale() {
        String cf = codiciFiscali.get(random.nextInt(codiciFiscali.size()));
        return GeneratoreDto.builder().codiceFiscale(cf).build();
    }
}
