package com.ornelas.foodapi.api.assembler;

import com.ornelas.foodapi.api.model.EstadoModel;
import com.ornelas.foodapi.api.model.input.EstadoInputModel;
import com.ornelas.foodapi.domain.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstadoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Estado toDomainObject(EstadoInputModel estadoModel){
        return modelMapper.map(estadoModel, Estado.class);
    }

    public void copyToDomainObject(EstadoInputModel estadoInputModel, Estado estado){
        modelMapper.map(estadoInputModel, estado);
    }
}
