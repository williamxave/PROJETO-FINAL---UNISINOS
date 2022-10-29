package br.com.xavero.projetofinal.services.user;

import br.com.xavero.projetofinal.controllers.user.dto.request.UserRequestDto;
import br.com.xavero.projetofinal.controllers.user.dto.request.UserRequestUpdateDto;
import br.com.xavero.projetofinal.controllers.user.dto.response.UserResponseDto;
import br.com.xavero.projetofinal.utils.GenericInterfaceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends GenericInterfaceService<UserRequestDto, UserResponseDto, UserRequestUpdateDto> {

    @Override
    String insert(UserRequestDto dto);

    @Override
    UserResponseDto find(String string);

    @Override
    void update(UserRequestUpdateDto dto);

    @Override
    Page<UserResponseDto> findAll(Pageable pageable);
}
