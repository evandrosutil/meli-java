package com.meli.obterdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ValidationErrorDTO {

    private String type;
    private String message;
}
