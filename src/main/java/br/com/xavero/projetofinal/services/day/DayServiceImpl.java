package br.com.xavero.projetofinal.services.day;

import br.com.xavero.projetofinal.domain.Day;
import br.com.xavero.projetofinal.dtos.day.DayRequestDto;
import br.com.xavero.projetofinal.dtos.day.DayResponseDto;
import br.com.xavero.projetofinal.dtos.day.DayUpdateDto;
import br.com.xavero.projetofinal.mappers.day.DayMapper;
import br.com.xavero.projetofinal.repositories.day.DayRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DayServiceImpl implements DayService {
    static final Logger LOG = LoggerFactory.getLogger(DayServiceImpl.class);

    @Value("${pattern.date}")
    private String pattern;

    private final DayRepository repository;
    private final DayMapper mapper;

    @Override
    public String insert(DayRequestDto dto) {
        var date = dto.date();
        LOG.info("Inserting day in db {}", date);
        var day = mapper.toDomain(dto);
        var response = repository.save(day);
        return response.getExternalId().toString();
    }

    @Override
    public DayResponseDto find(String externalId) {
        LOG.info("Finding day in db {}", externalId);
        return mapper.toDto(findDayByExternalId(externalId));
    }

    @Override
    public void update(DayUpdateDto dto) {
        // FAZER O UPDATE DEPOIS QUE A FEATURE DAS HORAS ESTIVER PRONTO
    }

    @Override
    public Page<DayResponseDto> findAll(Pageable pageable) {
        LOG.info("Finding all days in db");
        return repository.findAll(pageable)
                .map(mapper::toDto);
    }

    private LocalDate dateParse(String date) {
        var formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, formatter);
    }

    private Day findDayByExternalId(String externalId) {
        return repository.findDayByExternalId(UUID.fromString(externalId)).orElseThrow(() -> {
            LOG.error("Day not found {}", externalId);
            return new IllegalArgumentException("Day not found");
        });
    }
}
