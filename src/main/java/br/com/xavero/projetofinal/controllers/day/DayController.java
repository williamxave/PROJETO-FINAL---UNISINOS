package br.com.xavero.projetofinal.controllers.day;

import br.com.xavero.projetofinal.controllers.day.dto.DayRequestDto;
import br.com.xavero.projetofinal.controllers.day.dto.DayResponseDto;
import br.com.xavero.projetofinal.controllers.day.mapper.DayMapper;
import br.com.xavero.projetofinal.services.day.DayService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/day")
@RequiredArgsConstructor
public class DayController {

    private final DayService dayService;
    private final DayMapper mapper;

    @PostMapping
    public ResponseEntity<Void> registerDay(@RequestBody DayRequestDto request, UriComponentsBuilder builder) {
        var id = dayService.insert(mapper.toDomain(request));
        var uri = builder.path("/{externalId}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{externalId}")
    public ResponseEntity<DayResponseDto> findDay(@PathVariable("externalId") String externalId) {
        var dayDomain = dayService.find(externalId);
        return ResponseEntity.ok(mapper.toResponseDto(dayDomain));
    }

    @GetMapping
    public ResponseEntity<Page<DayResponseDto>> findAllDay(Pageable pageable) {
        return ResponseEntity.ok(dayService.findAll(pageable).map(mapper::toResponseDto));
    }
}