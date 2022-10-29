package br.com.xavero.projetofinal.controllers.day.mapper;

import br.com.xavero.projetofinal.controllers.day.dto.request.DayRequestDomain;
import br.com.xavero.projetofinal.controllers.day.dto.request.DayRequestDto;
import br.com.xavero.projetofinal.controllers.day.dto.response.DayResponseDto;
import br.com.xavero.projetofinal.domain.Day;
import br.com.xavero.projetofinal.repositories.day.entity.request.DayRequestEntity;
import br.com.xavero.projetofinal.repositories.day.entity.response.DayResponseEntity;
import br.com.xavero.projetofinal.services.day.domain.response.DayResponseDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface DayMapper {

    @Mapping(source = "dto", target = "date", qualifiedByName = "parseDate")
    DayRequestEntity toRequestEntity(DayRequestDomain dto);

    @Named(value = "parseDate")
    default LocalDate parseDate(DayRequestDomain dto) {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dto.date(), formatter);
    }

    DayResponseDto toDto(Day day);

    DayRequestDomain toDomain(DayRequestDto requestDto);

    DayResponseEntity toResponseEntity(Day day);
    Day toEntity(DayRequestEntity dayRequestEntity);

    DayResponseDomain toResponseDomain(DayResponseEntity entity);

    DayResponseDto toResponseDto (DayResponseDomain dayResponseDomain);

}
