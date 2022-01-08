package com.ornelas.foodapi.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CozinhaNomeInputModel {

    @NotBlank
    private String nome;
}
