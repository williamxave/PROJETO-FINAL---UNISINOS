package br.com.xavero.projetofinal.repositories.day.dto;

import java.time.LocalDate;
import java.util.UUID;

public record DayResponseEntity(UUID externalId, LocalDate date) {

}