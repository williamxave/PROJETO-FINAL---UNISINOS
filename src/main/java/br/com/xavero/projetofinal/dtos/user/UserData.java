package br.com.xavero.projetofinal.dtos.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record UserData(@NotBlank String name,@NotBlank @Email String email) { }
