package com.ornelas.foodapi.domain.repository;

import com.ornelas.foodapi.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
