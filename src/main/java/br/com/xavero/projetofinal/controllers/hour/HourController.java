package br.com.xavero.projetofinal.controllers.hour;

import br.com.xavero.projetofinal.controllers.hour.dto.HourRequestDto;
import br.com.xavero.projetofinal.controllers.hour.dto.HourResponseDto;
import br.com.xavero.projetofinal.services.hour.HourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/hours")
@RequiredArgsConstructor
public class HourController {

    private final HourService service;

    @PostMapping
    public ResponseEntity<HourResponseDto> registerHour(HourRequestDto requestDto, UriComponentsBuilder builder){

        var id = service.insert(requestDto);


        var uri = builder.path("/{externalId}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

}