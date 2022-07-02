package br.com.xavero.projetofinal.controllers.hour.mapper;

import br.com.xavero.projetofinal.domain.Hour;
import br.com.xavero.projetofinal.controllers.hour.dto.HourRequestDto;
import br.com.xavero.projetofinal.controllers.hour.dto.HourResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HourMapper {

   // Hour toDomain(HourRequestDto requestDto);

    HourResponseDto toResponse(Hour hour);




}