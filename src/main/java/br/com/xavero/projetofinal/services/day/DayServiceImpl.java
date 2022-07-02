package br.com.xavero.projetofinal.services.day;

import br.com.xavero.projetofinal.controllers.day.dto.DayRequestDomain;
import br.com.xavero.projetofinal.controllers.day.dto.DayUpdateDto;
import br.com.xavero.projetofinal.controllers.day.mapper.DayMapper;
import br.com.xavero.projetofinal.domain.Day;
import br.com.xavero.projetofinal.repositories.day.DayRepository;
import br.com.xavero.projetofinal.repositories.day.DayRepositoryImpl;
import br.com.xavero.projetofinal.services.day.dto.DayResponseDomain;
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

    private final DayRepositoryImpl dayRepository;
    private final DayMapper mapper;

    @Override
    public String insert(DayRequestDomain domain) {
        var date = domain.date();
        LOG.info("Inserting day in db {}", date);
        return dayRepository.save(mapper.toRequestEntity(domain));

    }

    @Override
    public DayResponseDomain find(String externalId) {
//        LOG.info("Finding day in db {}", externalId);
//        return mapper.toDto(findDayByExternalId(externalId));
        return mapper.toResponseDomain(dayRepository.findDay(externalId));

    }

    @Override
    public void update(DayUpdateDto dto) {
        // FAZER O UPDATE DEPOIS QUE A FEATURE DAS HORAS ESTIVER PRONTO
    }

    @Override
    public Page<DayResponseDomain> findAll(Pageable pageable) {
        return dayRepository.findAllDay(pageable).map(mapper::toResponseDomain);
    }
//
//    private LocalDate dateParse(String date) {
//        var formatter = DateTimeFormatter.ofPattern(pattern);
//        return LocalDate.parse(date, formatter);
//    }
//
//    private Day findDayByExternalId(String externalId) {
//        return repository.findDayByExternalId(UUID.fromString(externalId)).orElseThrow(() -> {
//            LOG.error("Day not found {}", externalId);
//            return new IllegalArgumentException("Day not found");
//        });
//    }
}
