package br.com.xavero.projetofinal.mappers.day;

import br.com.xavero.projetofinal.domain.Day;
import br.com.xavero.projetofinal.dtos.day.DayRequestDto;
import br.com.xavero.projetofinal.dtos.day.DayResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface DayMapper {

    @Mapping(source = "dto", target = "date", qualifiedByName = "parseDate")
    Day toDomain (DayRequestDto dto);

    DayResponseDto toDto (Day day);

    @Named(value = "parseDate")
    default LocalDate parseDate(DayRequestDto dto){
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dto.date(), formatter);
    }
}
