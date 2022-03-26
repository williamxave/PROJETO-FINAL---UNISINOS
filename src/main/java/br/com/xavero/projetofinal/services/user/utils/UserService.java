package br.com.xavero.projetofinal.services.user.utils;

import br.com.xavero.projetofinal.domain.User;
import br.com.xavero.projetofinal.dtos.user.UserRequestDto;
import br.com.xavero.projetofinal.dtos.user.UserRequestUpdateDto;
import br.com.xavero.projetofinal.dtos.user.UserResponseDto;

public interface UserService {

    User insertUser(UserRequestDto dto);
    UserResponseDto findUser(String email);
    void updateUser(UserRequestUpdateDto dto);
}
