package com.ornelas.foodapi.domain.repository;




import com.ornelas.foodapi.domain.model.FormaPagamento;


import java.util.List;

public interface FormaPagamentoRepository {

    List<FormaPagamento> listar();
    FormaPagamento buscar(Long id);
    FormaPagamento salvar(FormaPagamento formaPagamento);
    void remover(FormaPagamento formaPagamento);
}
