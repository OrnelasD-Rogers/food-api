package com.ornelas.foodapi.api.assembler;

import com.ornelas.foodapi.api.model.input.CidadeInputModel;
import com.ornelas.foodapi.domain.model.Cidade;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cidade toDomainModel(CidadeInputModel cidadeInputModel){
        return modelMapper.map(cidadeInputModel, Cidade.class);
    }

    public void copyToDomainModel(CidadeInputModel cidadeInputModel, Cidade cidade){
        modelMapper.map(cidadeInputModel, cidade);
    }
}
