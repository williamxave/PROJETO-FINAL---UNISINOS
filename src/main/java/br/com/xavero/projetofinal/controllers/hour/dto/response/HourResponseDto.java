package br.com.xavero.projetofinal.controllers.hour.dto.response;

import br.com.xavero.projetofinal.enums.PossibleHourEnum;
import br.com.xavero.projetofinal.utils.ResponseDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record HourResponseDto(UUID externalId, Boolean checkRent, LocalDateTime rented, PossibleHourEnum possibleHourEnum) implements ResponseDto {
}
