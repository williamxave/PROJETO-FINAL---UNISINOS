package br.com.xavero.projetofinal.controllers.user.dto;


import br.com.xavero.projetofinal.utils.UpdateDto;

import javax.validation.constraints.NotNull;

public record UserRequestUpdateDto(
        @NotNull
        UserData userData
) implements UpdateDto {
}
