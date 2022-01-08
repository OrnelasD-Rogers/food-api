package com.ornelas.foodapi.api.controller;

import com.ornelas.foodapi.api.assembler.EstadoInputDisassembler;
import com.ornelas.foodapi.api.assembler.EstadoModelAssembler;
import com.ornelas.foodapi.api.model.EstadoModel;
import com.ornelas.foodapi.api.model.input.EstadoInputModel;
import com.ornelas.foodapi.domain.exception.EntidadeEmUsoException;
import com.ornelas.foodapi.domain.exception.EntidadeNaoEncontradaException;
import com.ornelas.foodapi.domain.model.Estado;
import com.ornelas.foodapi.domain.service.EstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    EstadoService estadoService;

    @Autowired
    EstadoModelAssembler assembler;

    @Autowired
    EstadoInputDisassembler disassembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<EstadoModel> listar(){
       return assembler.toCollectionModel(estadoService.listar());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public EstadoModel buscar(@PathVariable Long id){
        return assembler.toModel(estadoService.buscar(id));
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EstadoModel adicionar(@Valid @RequestBody EstadoInputModel estadoInputModel){
        Estado estado = disassembler.toDomainObject(estadoInputModel);
        return assembler.toModel(estadoService.salvar(estado));
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public EstadoModel atualizar(@PathVariable Long id, @Valid @RequestBody EstadoInputModel estadoInputModel){
            Estado estadoAtual = estadoService.buscar(id);
            disassembler.copyToDomainObject(estadoInputModel, estadoAtual);
            return assembler.toModel(estadoService.salvar(estadoAtual));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        estadoService.remover(id);
    }
}
