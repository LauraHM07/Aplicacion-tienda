package com.laura.springprojects.tienda.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laura.springprojects.tienda.dao.ClientesDAO;
import com.laura.springprojects.tienda.dao.DetallePedidoDAO;
import com.laura.springprojects.tienda.dao.PedidosDAO;
import com.laura.springprojects.tienda.model.Cliente;
import com.laura.springprojects.tienda.model.DetallePedido;
import com.laura.springprojects.tienda.model.Pedido;
import com.laura.springprojects.tienda.services.PedidosService;

@Service
public class PedidosServiceImpl implements PedidosService {
    @Autowired
    PedidosDAO pedidosDAO;

    @Autowired
    DetallePedidoDAO detallePedidoDAO;

    @Autowired
    ClientesDAO clientesDAO;

    @Override
    public Page<Pedido> findAll(Pageable pageable) {
        return pedidosDAO.findAll(pageable);
    }

    @Override
    public Pedido find(int codigo) {
        Pedido pedido = pedidosDAO.find(codigo);

        Cliente cliente = clientesDAO.findById(pedido.getCliente().getCodigo());

        pedido.setCliente(cliente);

        List<DetallePedido> detalle = detallePedidoDAO.findDetalle(pedido);
        pedido.setDetallePedidos(detalle);
        
        return pedido;
    }

    @Override
    public void save(Pedido pedido) {
        
        pedidosDAO.insert(pedido);

        List<DetallePedido> detallePedidos = pedido.getDetallePedidos();
        for (DetallePedido detallePedido : detallePedidos) {
            detallePedidoDAO.insert(pedido, detallePedido);
        }

    }

    // @Override
    // public void update(Pedido pedido) {
    //     pedidosDAO.update(pedido);
    // }

    @Override
    public void delete(int codigo) {
        pedidosDAO.delete(codigo);        
    }
}
