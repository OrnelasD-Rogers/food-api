package com.ornelas.foodapi.domain.service;

import com.ornelas.foodapi.domain.exception.RestauranteNaoEncontradoException;
import com.ornelas.foodapi.domain.model.Cozinha;
import com.ornelas.foodapi.domain.model.Restaurante;
import com.ornelas.foodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    RestauranteRepository restauranteRepository;

    @Autowired
    CadastroCozinhaService cozinhaService;


    public List<Restaurante> listar(){
        return restauranteRepository.findAll();
    }


    public Restaurante buscar(Long id){
        return restauranteRepository.findById(id)
                .orElseThrow(()-> new RestauranteNaoEncontradoException(id));
    }


    @Transactional
    public Restaurante salvar(Restaurante restaurante){
        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaService.buscarOuFalhar(cozinhaId);
        restaurante.setCozinha(cozinha);
        return restauranteRepository.save(restaurante);
    }


    @Transactional
    public void remover(Long id){
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(()-> new RestauranteNaoEncontradoException(id));
        restauranteRepository.deleteById(id);
    }

    public List<Restaurante> findRestaurantesPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal){
        return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
    }

    public List<Restaurante> consultarPorNome(String nome, Long idCozinha){
        return restauranteRepository.consultarPorNome( nome,  idCozinha);
    }

    public Restaurante findFirstRestauranteByNomeContaining(String nome){
        return restauranteRepository.findFirstRestauranteByNomeContaining(nome)
                .orElseThrow(()-> new RestauranteNaoEncontradoException(
                        String.format("Restaurante com nome %s não encontrado", nome)));
    }

    public List<Restaurante> findTop2ByNomeContaining(String nome){
        return restauranteRepository.findTop2ByNomeContaining(nome);
    }

    public List<Restaurante> findNomeFrete(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
        return restauranteRepository.findNomeFrete(nome, taxaFreteInicial, taxaFreteFinal);
    }
}
