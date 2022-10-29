package br.com.xavero.projetofinal.services.day.domain.response;

import br.com.xavero.projetofinal.utils.ResponseDto;

import java.time.LocalDate;
import java.util.UUID;

public record DayResponseDomain(UUID externalId, LocalDate date) implements ResponseDto {
}