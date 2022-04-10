package br.com.xavero.projetofinal.services.day;

import br.com.xavero.projetofinal.dtos.day.DayRequestDto;
import br.com.xavero.projetofinal.dtos.day.DayResponseDto;
import br.com.xavero.projetofinal.dtos.day.DayUpdateDto;
import br.com.xavero.projetofinal.utils.GenericInterfaceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DayService extends GenericInterfaceService<DayRequestDto, DayResponseDto, DayUpdateDto> {

    @Override
    String insert(DayRequestDto dto);

    @Override
    DayResponseDto find(String string);

    @Override
    void update(DayUpdateDto dto);

    @Override
    Page<DayResponseDto> findAll(Pageable pageable);

}
