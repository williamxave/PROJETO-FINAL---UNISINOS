package br.com.xavero.projetofinal.services.user;

import br.com.xavero.projetofinal.dtos.user.UserRequestDto;
import br.com.xavero.projetofinal.dtos.user.UserRequestUpdateDto;
import br.com.xavero.projetofinal.dtos.user.UserResponseDto;
import br.com.xavero.projetofinal.domain.User;
import br.com.xavero.projetofinal.mappers.user.UserMapper;
import br.com.xavero.projetofinal.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserMapper userMapper;
    private final UserRepository repository;

    @Override
    public String insert(UserRequestDto dto) {
        String email = dto.userData().email();
        LOG.info("Inserting user in db {}", email);
        var user = userMapper.toUserDomain(dto);
        return repository.save(user).getEmail();
    }

    @Override
    public UserResponseDto find(String email) {
        LOG.info("Finding user in db {}", email);
        return userMapper.toResponseDto(findUserByEmail(email));
    }

    @Override
    public void update(UserRequestUpdateDto dto) {
        String email = dto.userData().email();
        LOG.info("Finding user in db {}", email);
        updateUser(findUserByEmail(email), dto);
        LOG.info("Updated successfully {}", email);
    }

    @Override
    public Page<UserResponseDto> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(userMapper::toResponseDto);
    }

    private User updateUser(User user, UserRequestUpdateDto dto) {
        user.setEmail(dto.userData().email());
        user.setName(dto.userData().name());
        repository.save(user);
        return user;
    }

    private User findUserByEmail(String email) {
        return repository.findUserByEmail(email).orElseThrow(() -> {
            LOG.error("User not found {}", email);
            return new IllegalArgumentException("User not found");
        });
    }
}