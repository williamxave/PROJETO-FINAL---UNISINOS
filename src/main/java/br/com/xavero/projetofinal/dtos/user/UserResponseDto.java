package br.com.xavero.projetofinal.dtos.user;


public record UserResponseDto(
        UserData userData,
        String externalId
) {
}
