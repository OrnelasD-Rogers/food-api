package com.ornelas.foodapi.api.controller;

import com.ornelas.foodapi.domain.model.Pedido;
import com.ornelas.foodapi.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> listar(){
        return pedidoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pedido> adicionar(@RequestBody Pedido pedido){
        Pedido novoPedido = pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
    }
}
