package br.com.xavero.projetofinal.controllers.user.dto;

import br.com.xavero.projetofinal.utils.RequestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record UserRequestDto(
        @NotNull
        UserData userData,
        @NotBlank
        String password
) implements RequestDto {

}
