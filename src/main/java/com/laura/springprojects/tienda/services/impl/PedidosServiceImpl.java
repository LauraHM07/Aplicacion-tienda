package com.laura.springprojects.tienda.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laura.springprojects.tienda.model.DetallePedido;
import com.laura.springprojects.tienda.model.DetallePedidoId;
import com.laura.springprojects.tienda.model.Pedido;
import com.laura.springprojects.tienda.repository.DetallePedidoRepository;
import com.laura.springprojects.tienda.repository.PedidoRepository;
import com.laura.springprojects.tienda.services.PedidosService;

@Service
public class PedidosServiceImpl implements PedidosService {
    @Autowired
    PedidoRepository repositoryPedido;

    @Autowired
    DetallePedidoRepository repositoryDetalle;

    @Override
    public Page<Pedido> findAll(Pageable pageable) {
        return repositoryPedido.findAll(pageable);
    }

    @Override
    public Pedido find(int codigo) {
        Optional<Pedido> findById = repositoryPedido.findById(codigo);
        if(findById != null){
            Pedido pedido = findById.get();

            pedido.setDetallePedidos(repositoryDetalle.findByPedidoCodigo(pedido.getCodigo()));
            
            return pedido;
        }

        return null;
    }

    @Override
    public void save(Pedido pedido) {
        
        repositoryPedido.save(pedido);

        List<DetallePedido> detallePedidos = pedido.getDetallePedidos();
        for (DetallePedido detallePedido : detallePedidos) {
            DetallePedidoId id = new DetallePedidoId(pedido.getCodigo(), detallePedido.getProducto().getCodigo());
            detallePedido.setId(id);
            repositoryDetalle.save(detallePedido);
        }

    }

    @Override
    @Transactional
    public void delete(int codigo) {
        Pedido pedido = new Pedido();
        pedido.setCodigo(codigo);

        repositoryDetalle.deleteByPedidoCodigo(codigo);

        repositoryPedido.deleteById(codigo);        
    }
}
