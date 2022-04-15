package br.com.xavero.projetofinal.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_day")
@Getter
@Setter
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID externalId;

    @Column(unique = true)
    private LocalDate date;

    @PostPersist
    public void posPersist() {
        externalId = UUID.randomUUID();
    }
}
