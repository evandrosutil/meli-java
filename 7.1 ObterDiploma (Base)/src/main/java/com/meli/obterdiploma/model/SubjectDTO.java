package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
@RequiredArgsConstructor
public class SubjectDTO {

    @NotBlank(message = "O nome do assunto não pode ficar vazio.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "\\b[A-Z].*\\b", message = "O nome do assunto deve começar com letra maiúscula.")
    String name;

    @NotNull(message = "A nota não pode estar vazia.")
    @DecimalMin(value = "0", message = "A nota mínima é 0,0.")
    @DecimalMax(value = "10", message = "A nota máxima é 10,0.")
    Double score;
}
