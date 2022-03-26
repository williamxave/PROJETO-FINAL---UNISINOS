package br.com.xavero.projetofinal.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID externalId;

    @NotBlank
    @Size(min = 5, max = 80)
    private String name;

    @NotBlank
    @Email
    @Column(unique = true)
    @Size(max = 50)
    private String email;

    @NotBlank
    private String password;

    private LocalDateTime lastLogin;

    @PostPersist
    public void posPersist() {
        externalId = UUID.randomUUID();
        lastLogin = LocalDateTime.now();
    }
}