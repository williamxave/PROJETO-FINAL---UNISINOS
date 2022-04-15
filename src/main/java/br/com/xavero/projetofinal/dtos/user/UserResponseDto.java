package br.com.xavero.projetofinal.dtos.user;


import br.com.xavero.projetofinal.utils.ResponseDto;

public record UserResponseDto(
        UserData userData,
        String externalId
) implements ResponseDto {
}
