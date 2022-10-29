package br.com.xavero.projetofinal.controllers.user.dto.response;


import br.com.xavero.projetofinal.controllers.user.dto.UserData;
import br.com.xavero.projetofinal.utils.ResponseDto;

public record UserResponseDto(
        UserData userData,
        String externalId
) implements ResponseDto {
}
