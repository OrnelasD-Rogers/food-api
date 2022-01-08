package com.ornelas.foodapi.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public class EstadoIdInputModel {

    @NotNull
    private Long id;
}
