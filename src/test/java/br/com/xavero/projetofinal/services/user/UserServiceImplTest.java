package br.com.xavero.projetofinal.services.user;

import br.com.xavero.projetofinal.dtos.user.UserData;
import br.com.xavero.projetofinal.dtos.user.UserRequestDto;
import br.com.xavero.projetofinal.dtos.user.UserRequestUpdateDto;
import br.com.xavero.projetofinal.dtos.user.UserResponseDto;
import br.com.xavero.projetofinal.domain.User;
import br.com.xavero.projetofinal.mappers.user.UserMapper;
import br.com.xavero.projetofinal.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@MockitoSettings
class UserServiceImplTest {
    private static final String EMAIL = "teste@testando.com";

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    private User user;
    private UserData data;
    private UserResponseDto responseDto;
    private UserRequestDto requestDto;
    private UserRequestUpdateDto updateDto;

    @BeforeEach
    void beforeAll() {
        user = new User();
        data = new UserData("William", "teste@testando.com");
        requestDto = new UserRequestDto(data, "123");
        responseDto = new UserResponseDto(data, "123");
        updateDto = new UserRequestUpdateDto(data);

    }

    @Test
    @DisplayName("Should insert user")
    void shouldInsertUser() {

        when(userMapper.toUserDomain(requestDto)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        User userResponse = userService.insertUser(requestDto);

        assertNotNull(userResponse);
        Mockito.verify(userRepository, Mockito.atLeastOnce()).save(user);

    }

    @Test
    @DisplayName("Should find user by email")
    void shouldFindUserByEmail() {

        when(userMapper.toResponseDto(user)).thenReturn(responseDto);
        when(userRepository.findUserByEmail(data.email())).thenReturn(Optional.of(user));
        UserResponseDto a = userService.findUser(data.email());

        assertNotNull(a);
        Mockito.verify(userRepository, Mockito.atLeastOnce()).findUserByEmail(data.email());
    }

    @Test
    @DisplayName("Should not find user by email")
    void shouldNotFindUserByEmail() {

        when(userRepository.findUserByEmail(EMAIL)).thenThrow(new IllegalArgumentException("User not found"));

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            userService.findUser(EMAIL);
        });
        Mockito.verify(userRepository, Mockito.atLeastOnce()).findUserByEmail(EMAIL);
        assertEquals("User not found", ex.getMessage());
    }

    @Test
    @DisplayName("Should update user")
    void shouldUpdateUser() {

        when(userRepository.findUserByEmail(data.email())).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);
        userService.updateUser(updateDto);

        Mockito.verify(userRepository, Mockito.atLeastOnce()).save(user);
        Mockito.verify(userRepository, Mockito.atLeastOnce()).findUserByEmail(data.email());

    }

    @Test
    @DisplayName("Should not update user")
    void shouldNotUpdateUser() {

        when(userRepository.findUserByEmail(data.email())).thenThrow(new IllegalArgumentException("User not found"));

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            userService.updateUser(updateDto);
        });
        Mockito.verify(userRepository, Mockito.atLeastOnce()).findUserByEmail(data.email());
        assertEquals("User not found", ex.getMessage());
    }
}