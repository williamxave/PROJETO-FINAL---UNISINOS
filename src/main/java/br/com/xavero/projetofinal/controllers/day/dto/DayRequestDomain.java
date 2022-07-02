package br.com.xavero.projetofinal.controllers.day.dto;

import br.com.xavero.projetofinal.utils.RequestDto;

public record DayRequestDomain(String date) implements RequestDto {
}
