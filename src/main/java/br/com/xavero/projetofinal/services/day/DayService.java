package br.com.xavero.projetofinal.services.day;

import br.com.xavero.projetofinal.controllers.day.dto.request.DayRequestDomain;
import br.com.xavero.projetofinal.controllers.day.dto.DayUpdateDto;
import br.com.xavero.projetofinal.services.day.domain.response.DayResponseDomain;
import br.com.xavero.projetofinal.utils.GenericInterfaceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DayService extends GenericInterfaceService<DayRequestDomain, DayResponseDomain, DayUpdateDto> {

    @Override
    String insert(DayRequestDomain domain);

    @Override
    DayResponseDomain find(String externalId);

    @Override
    void update(DayUpdateDto dto);

    @Override
    Page<DayResponseDomain> findAll(Pageable pageable);

}
