package com.ornelas.foodapi.api.controller;

import com.ornelas.foodapi.api.assembler.RestauranteInputDisassembler;
import com.ornelas.foodapi.api.assembler.RestauranteModelAssembler;
import com.ornelas.foodapi.api.model.RestauranteModel;
import com.ornelas.foodapi.api.model.input.RestauranteInputModel;
import com.ornelas.foodapi.domain.exception.EntidadeNaoEncontradaException;
import com.ornelas.foodapi.domain.exception.NegocioException;
import com.ornelas.foodapi.domain.model.Restaurante;
import com.ornelas.foodapi.domain.service.RestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    RestauranteService restauranteService;

    @Autowired
    private SmartValidator validator;

    @Autowired
    private RestauranteModelAssembler assembler;

    @Autowired
    private RestauranteInputDisassembler desassembler;

    @GetMapping
    public List<RestauranteModel> listar() {
        return assembler.toCollectionModel(restauranteService.listar());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public RestauranteModel buscar(@PathVariable Long id){
        Restaurante restaurante = restauranteService.buscar(id);
        return assembler.toModel(restaurante);
    }



    @GetMapping("/por-taxa-frete")
    public List<RestauranteModel> restaurantePorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal){
        List<Restaurante> restaurantes = restauranteService.findRestaurantesPorTaxaFrete(taxaInicial, taxaFinal);
        return assembler.toCollectionModel(restaurantes);
    }

    @GetMapping("/por-nome")
    public List<RestauranteModel> restaurantePorTaxaFrete(String nome, Long idCozinha){
        List<Restaurante> restaurantes = restauranteService.consultarPorNome(nome, idCozinha);
        return assembler.toCollectionModel(restaurantes);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/primeiro-por-nome")
    public RestauranteModel restaurantePrimeiroPorNome(String nome){
        return assembler.toModel(restauranteService.findFirstRestauranteByNomeContaining(nome));
    }

    @GetMapping("/top2-por-nome")
    public List<RestauranteModel> top2RestaurantesPorNome(String nome){
        return assembler.toCollectionModel(restauranteService.findTop2ByNomeContaining(nome));
    }

    @GetMapping("/por-nome-e-frete")
    public List<RestauranteModel> restaurantesPorNomeFrete(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
        return assembler.toCollectionModel(restauranteService.findNomeFrete(nome, taxaFreteInicial, taxaFreteFinal));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RestauranteModel adicionar(
            @Valid @RequestBody RestauranteInputModel restauranteInput){
        Restaurante restaurante = desassembler.toDomainObject(restauranteInput);
        return assembler.toModel(restauranteService.salvar(restaurante));
    }



    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public RestauranteModel atualizar(@PathVariable Long id, @Valid @RequestBody RestauranteInputModel restauranteInput){
        Restaurante restauranteAtual = restauranteService.buscar(id);
        desassembler.copyToDomainObject(restauranteInput, restauranteAtual);
        try {
            return assembler.toModel(restauranteService.salvar(restauranteAtual));
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        restauranteService.remover(id);
    }


}
