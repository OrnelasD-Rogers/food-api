package com.ornelas.foodapi.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class RestauranteModel {

    private Long id;
    private String nome;
    private BigDecimal precoFrete;
    private CozinhaModel cozinha;

}
