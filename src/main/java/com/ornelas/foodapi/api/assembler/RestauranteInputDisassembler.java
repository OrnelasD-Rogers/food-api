package com.ornelas.foodapi.api.assembler;

import com.ornelas.foodapi.api.model.input.RestauranteInputModel;
import com.ornelas.foodapi.domain.model.Cozinha;
import com.ornelas.foodapi.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestauranteInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Restaurante toDomainObject(RestauranteInputModel restauranteInput) {
        return modelMapper.map(restauranteInput, Restaurante.class);
    }

    public void copyToDomainObject(RestauranteInputModel restauranteInputModel, Restaurante restaurante){
        //Para evitar org.hibernate.HibernateException:
        // indentifier of an instance of com.ornelas.foodapi.domain.Cozinha was altered from 1 to 2
        restaurante.setCozinha(new Cozinha());
        modelMapper.map(restauranteInputModel, restaurante);
    }
}
