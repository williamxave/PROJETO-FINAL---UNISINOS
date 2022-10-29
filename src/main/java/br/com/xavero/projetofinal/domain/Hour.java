package br.com.xavero.projetofinal.domain;

import br.com.xavero.projetofinal.enums.PossibleHourEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_hour")
@Getter
@Setter
public class Hour {

    private Long id;

    private UUID externalId = UUID.randomUUID();

    private Boolean checkRent;

    private LocalDateTime rented;

    private PossibleHourEnum possibleHourEnum;

}
