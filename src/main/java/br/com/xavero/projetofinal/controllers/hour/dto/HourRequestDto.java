package br.com.xavero.projetofinal.controllers.hour.dto;

import br.com.xavero.projetofinal.utils.RequestDto;

public record HourRequestDto(String externalId,String hour) implements RequestDto {
}
