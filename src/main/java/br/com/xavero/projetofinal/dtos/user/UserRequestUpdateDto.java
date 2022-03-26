package br.com.xavero.projetofinal.dtos.user;


import javax.validation.constraints.NotNull;

public record UserRequestUpdateDto(
        @NotNull
        UserData userData
) {
}
