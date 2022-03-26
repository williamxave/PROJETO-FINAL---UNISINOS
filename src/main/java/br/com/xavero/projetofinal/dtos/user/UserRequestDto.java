package br.com.xavero.projetofinal.dtos.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record UserRequestDto(
        @NotNull
        UserData userData,
        @NotBlank
        String password
) {

}
