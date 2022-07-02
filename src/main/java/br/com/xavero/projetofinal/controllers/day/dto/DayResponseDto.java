package br.com.xavero.projetofinal.controllers.day.dto;

import br.com.xavero.projetofinal.utils.ResponseDto;

import java.time.LocalDate;
import java.util.UUID;

public record DayResponseDto(UUID externalId, LocalDate date) implements ResponseDto {
}
