package br.com.xavero.projetofinal.services.day;

import br.com.xavero.projetofinal.controllers.day.dto.DayRequestDomain;
import br.com.xavero.projetofinal.controllers.day.dto.DayResponseDto;
import br.com.xavero.projetofinal.controllers.day.mapper.DayMapper;
import br.com.xavero.projetofinal.domain.Day;
import br.com.xavero.projetofinal.repositories.day.DayRepository;
import br.com.xavero.projetofinal.repositories.day.dto.DayRequestEntity;
import br.com.xavero.projetofinal.services.day.dto.DayResponseDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@MockitoSettings
class DayServiceImplTest {
    private static final String DATE = "01/02/2022";
    private static final UUID EXTERNAL_ID = UUID.randomUUID();

    @InjectMocks
    private DayServiceImpl dayService;

    @Mock
    private DayRepository repository;

    @Spy
    private DayMapper mapper = spy(DayMapper.class);

    @Autowired
    private Pageable pageable;

    @Test
    @DisplayName("Should register day")
    void shouldRegisterDay() {
        var requestDomain = new DayRequestDomain(DATE);

        var requestEntity = new DayRequestEntity(LocalDate.now());

        var day = new Day();
        day.setExternalId(EXTERNAL_ID);

        when(mapper.toRequestEntity(requestDomain)).thenReturn(requestEntity);
        when(repository.save(day)).thenReturn(day);
        var externalId = dayService.insert(requestDomain);

        assertNotNull(externalId);
        assertEquals(EXTERNAL_ID, UUID.fromString(externalId));
        verify(mapper, Mockito.atLeastOnce()).toRequestEntity(requestDomain);
        verify(repository, Mockito.atLeastOnce()).save(day);

    }

    @Test
    @DisplayName("Should find day")
    void shouldFindDay() {
        var day = new Day();
        day.setExternalId(EXTERNAL_ID);

        var response = new DayResponseDto(EXTERNAL_ID, LocalDate.now());

        when(repository.findDayByExternalId(EXTERNAL_ID)).thenReturn(Optional.of(day));
        when(mapper.toDto(day)).thenReturn(response);
        dayService.find(EXTERNAL_ID.toString());

        verify(mapper, Mockito.atLeastOnce()).toDto(day);
        verify(repository, Mockito.atLeastOnce()).findDayByExternalId(EXTERNAL_ID);

    }

    @Test
    @DisplayName("Should not find day")
    void shouldNotFindDay() {

        when(repository.findDayByExternalId(EXTERNAL_ID)).thenThrow(new IllegalArgumentException("Day not found"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dayService.find(EXTERNAL_ID.toString());
        });
        Mockito.verify(repository, Mockito.atLeastOnce()).findDayByExternalId(EXTERNAL_ID);

    }

    @Test
    @DisplayName("Should find all days ")
    void shouldFindAllDays() {
        Page<Day> page = Page.empty();

        when(repository.findAll(pageable)).thenReturn(page);
        Page<DayResponseDomain> responseDomains = dayService.findAll(pageable);

        assertNotNull(responseDomains);
        Mockito.verify(repository, Mockito.atLeastOnce()).findAll(pageable);
    }
}