package br.com.xavero.projetofinal.controllers.hour.dto;

import br.com.xavero.projetofinal.enuns.PossibleHour;
import br.com.xavero.projetofinal.utils.ResponseDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record HourResponseDto(UUID externalId, Boolean checkRent, LocalDateTime rented, PossibleHour possibleHour) implements ResponseDto {
}
