package br.com.xavero.projetofinal.controllers.user;

import br.com.xavero.projetofinal.dtos.user.UserRequestDto;
import br.com.xavero.projetofinal.dtos.user.UserRequestUpdateDto;
import br.com.xavero.projetofinal.dtos.user.UserResponseDto;
import br.com.xavero.projetofinal.services.user.utils.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/insert")
    public ResponseEntity<Void> insertUser(@RequestBody UserRequestDto request, UriComponentsBuilder builder) {
        var user = userService.insertUser(request);
        var uri = builder.path("/{email}").buildAndExpand(user.getEmail()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<UserResponseDto> findUserByEmail(@PathVariable(value = "email") String email) {
        var userDto = userService.findUser(email);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateUser(@RequestBody UserRequestUpdateDto request) {
        userService.updateUser(request);
        return ResponseEntity.noContent().build();
    }
}
