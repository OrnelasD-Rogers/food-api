package com.ornelas.foodapi.api.controller;

import com.ornelas.foodapi.api.assembler.CidadeInputDisassembler;
import com.ornelas.foodapi.api.assembler.CidadeModelAssembler;
import com.ornelas.foodapi.api.model.CidadeModel;
import com.ornelas.foodapi.api.model.input.CidadeInputModel;
import com.ornelas.foodapi.domain.exception.EstadoNaoEncontradoException;
import com.ornelas.foodapi.domain.exception.NegocioException;
import com.ornelas.foodapi.domain.model.Cidade;
import com.ornelas.foodapi.domain.service.CidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    CidadeService cidadeService;

    @Autowired
    CidadeModelAssembler assembler;

    @Autowired
    CidadeInputDisassembler disassembler;

    @GetMapping
    public List<CidadeModel> listar(){
        return assembler.toCollectionModel(cidadeService.listar());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CidadeModel buscar(@PathVariable Long id){
        return assembler.toModel(cidadeService.buscar(id));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CidadeModel adicionar(@Valid @RequestBody CidadeInputModel cidadeInputModel){
        Cidade cidade = disassembler.toDomainModel(cidadeInputModel);
        return assembler.toModel(cidadeService.salvar(cidade));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public CidadeModel atualizar(@Valid @PathVariable Long id, @RequestBody CidadeInputModel cidadeInputModel){
        Cidade cidadeAtual = cidadeService.buscar(id);
        disassembler.copyToDomainModel(cidadeInputModel, cidadeAtual);
        return assembler.toModel(cidadeService.salvar(cidadeAtual));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        cidadeService.remover(id);
    }



}
