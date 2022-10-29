package br.com.xavero.projetofinal.repositories.day;

import br.com.xavero.projetofinal.controllers.day.mapper.DayMapper;
import br.com.xavero.projetofinal.repositories.day.entity.request.DayRequestEntity;
import br.com.xavero.projetofinal.repositories.day.entity.response.DayResponseEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DayRepositoryImpl {
    static final Logger LOG = LoggerFactory.getLogger(DayRepositoryImpl.class);

    private final DayRepository repository;
    private final DayMapper mapper;

    public DayResponseEntity findDay(String externalId) {
        return repository.findDayByExternalId(UUID.fromString(externalId)).map(mapper::toResponseEntity).orElseThrow(() -> {
            LOG.error("Day not found {}", externalId);
            return new IllegalArgumentException("Day not found");
        });
    }

    public String save(DayRequestEntity dayRequestEntity) {
        var day = mapper.toEntity(dayRequestEntity);
        LOG.info("Save day in db");
        return repository.save(day).getExternalId().toString();
    }

    public Page<DayResponseEntity> findAllDay(Pageable pageable) {
        LOG.info("Finding all days in db");
        return repository.findAll(pageable).map(mapper::toResponseEntity);
    }
}

