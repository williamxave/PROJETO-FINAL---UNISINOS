package br.com.xavero.projetofinal.services.hour;

import br.com.xavero.projetofinal.controllers.hour.dto.HourRequestDto;
import br.com.xavero.projetofinal.controllers.hour.dto.HourResponseDto;
import br.com.xavero.projetofinal.controllers.hour.dto.HourUpdateDto;
import br.com.xavero.projetofinal.utils.GenericInterfaceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HourService extends GenericInterfaceService<HourRequestDto, HourResponseDto, HourUpdateDto> {

    @Override
    String insert(HourRequestDto dto);

    @Override
    HourResponseDto find(String string);

    @Override
    void update(HourUpdateDto dto);

    @Override
    Page<HourResponseDto> findAll(Pageable pageable);

}
