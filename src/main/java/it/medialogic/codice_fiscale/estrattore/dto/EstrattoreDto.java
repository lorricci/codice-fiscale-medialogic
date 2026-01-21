package it.medialogic.codice_fiscale.estrattore.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EstrattoreDto {

    private LocalDate dataNascita;
    private Integer eta;
}
