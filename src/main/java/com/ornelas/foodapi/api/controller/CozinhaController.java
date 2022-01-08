package com.ornelas.foodapi.api.controller;

import com.ornelas.foodapi.api.assembler.CozinhaInputDisassembler;
import com.ornelas.foodapi.api.assembler.CozinhaModelAssembler;
import com.ornelas.foodapi.api.model.CozinhaModel;
import com.ornelas.foodapi.api.model.input.CozinhaNomeInputModel;
import com.ornelas.foodapi.domain.model.Cozinha;
import com.ornelas.foodapi.domain.repository.CozinhaRepository;
import com.ornelas.foodapi.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    @Autowired
    private CozinhaModelAssembler assembler;

    @Autowired
    private CozinhaInputDisassembler disassembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CozinhaModel adicionar(@RequestBody @Valid CozinhaNomeInputModel cozinhaNomeInputModel){
        Cozinha cozinha = disassembler.toDomainObject(cozinhaNomeInputModel);
        return assembler.toModel(cadastroCozinha.salvar(cozinha));
    }

    @GetMapping
    public List<CozinhaModel> listar(){
        return assembler.toCollectionModel(cozinhaRepository.findAll());
    }


    @GetMapping("/{cozinhaId}")
    public CozinhaModel buscar(@PathVariable Long cozinhaId){
        return assembler.toModel(cadastroCozinha.buscarOuFalhar(cozinhaId));
    }



    @GetMapping("/por-nome")
    public List<CozinhaModel> buscarPorNome(@RequestParam String nomeCozinha){
        //Query String
        return assembler.toCollectionModel(cozinhaRepository.findCozinhasByNome(nomeCozinha));
    }

    @GetMapping("/exists")
    public boolean existsPorNome(String nome){
        //Query String
        return cozinhaRepository.existsByNome(nome);
    }



    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public CozinhaModel atualizar(@PathVariable Long id, @Valid @RequestBody CozinhaNomeInputModel cozinhaNomeInputModel){
        Cozinha cozinhaAtual = cadastroCozinha.buscarOuFalhar(id);
        disassembler.copyToDomainObject(cozinhaNomeInputModel, cozinhaAtual);
        return assembler.toModel(cadastroCozinha.salvar(cozinhaAtual));

    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
            cadastroCozinha.excluir(id);
    }
}
