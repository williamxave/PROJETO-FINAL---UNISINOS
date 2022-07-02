package br.com.xavero.projetofinal.controllers.user.mapper;

import br.com.xavero.projetofinal.controllers.user.dto.UserRequestDto;
import br.com.xavero.projetofinal.controllers.user.dto.UserResponseDto;
import br.com.xavero.projetofinal.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "name", source = "dto.userData.name")
    @Mapping(target = "email", source = "dto.userData.email")
    User toUserDomain(UserRequestDto dto);


    @Mapping(target = "externalId", source = "user", qualifiedByName = "getToString")
    @Mapping(target = "userData.name", source = "name")
    @Mapping(target = "userData.email", source = "email")
    UserResponseDto toResponseDto(User user);

    @Named("getToString")
    default String getToString(User user) {
        return user.getExternalId().toString();
    }
}