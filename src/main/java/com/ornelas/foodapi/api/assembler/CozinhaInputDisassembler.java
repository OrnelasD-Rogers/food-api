package com.ornelas.foodapi.api.assembler;

import com.ornelas.foodapi.api.model.input.CozinhaNomeInputModel;
import com.ornelas.foodapi.domain.model.Cozinha;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CozinhaInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cozinha toDomainObject(CozinhaNomeInputModel cozinhaNomeInputModel){
        return modelMapper.map(cozinhaNomeInputModel, Cozinha.class);
    }

    public void copyToDomainObject(CozinhaNomeInputModel cozinhaNomeInputModel, Cozinha cozinha){
        modelMapper.map(cozinhaNomeInputModel, cozinha);
    }
}
