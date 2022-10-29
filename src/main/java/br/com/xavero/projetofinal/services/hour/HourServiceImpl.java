package br.com.xavero.projetofinal.services.hour;

import br.com.xavero.projetofinal.controllers.hour.dto.request.HourRequestDto;
import br.com.xavero.projetofinal.controllers.hour.dto.response.HourResponseDto;
import br.com.xavero.projetofinal.controllers.hour.dto.HourUpdateDto;
import br.com.xavero.projetofinal.controllers.hour.mapper.HourMapper;
import br.com.xavero.projetofinal.repositories.hour.HourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HourServiceImpl implements HourService{

    private final HourRepository repository;
    private final HourMapper mapper;

    @Override
    public String insert(HourRequestDto dto) {

        return null;
    }

    @Override
    public HourResponseDto find(String externalId) {
        return mapper.toResponse(repository.findHourByExternalId(UUID.fromString(externalId)).orElseThrow( () -> new IllegalArgumentException("teste")));
    }

    @Override
    public void update(HourUpdateDto dto) {

    }

    @Override
    public Page<HourResponseDto> findAll(Pageable pageable) {
        return null;
    }
}
