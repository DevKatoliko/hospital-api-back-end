package dtos.creations;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record HospitalCreationDTO(
        @NotBlank(message = "O nome do hospital não pode estar em branco")
        @Size(max = 32, message = "O nome do hospital deve conter no máximo 32 caracteres")
        String name,
        @Valid
        @NotNull(message = "O endereço é obrigatório!")
        AddressCreationDTO address,
        @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message= "Telefone inválido! Use o formato (XX)XXXXX-XXXX")
        @NotBlank(message = "O telefone não pode estar em branco!")
        String telephone,
        @NotNull(message = "O valor da consulta não pode ser nulo!")
        @PositiveOrZero(message = "O valor da consulta deve ser positivo ou zero")
        @Digits(integer = 10, fraction = 2, message = "O valor da consulta deve ter no máximo 10 dígitos inteiros e 2 decimais")
        BigDecimal consultationPrice,
        @NotNull(message = "O valor da internação não pode ser nulo!")
        @PositiveOrZero(message = "O valor da internação deve ser positivo ou zero")
        @Digits(integer = 10, fraction = 2, message = "O valor da internação deve ter no máximo 10 dígitos inteiros e 2 decimais")
        BigDecimal hospitalizationPrice,
        @NotNull(message = "O valor do caixa não pode ser nulo!")
        @PositiveOrZero(message = "O valor do caixa deve ser positivo ou zero")
        @Digits(integer = 10, fraction = 2, message = "O valor do caixa deve ter no máximo 10 dígitos inteiros e 2 decimais")
        BigDecimal hospitalCash
) { }
