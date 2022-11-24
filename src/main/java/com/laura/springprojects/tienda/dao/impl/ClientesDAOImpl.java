package com.laura.springprojects.tienda.dao.impl;

import com.laura.springprojects.tienda.dao.ClientesDAO;
import com.laura.springprojects.tienda.dao.mappers.ClienteMapper;
import com.laura.springprojects.tienda.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class ClientesDAOImpl extends JdbcDaoSupport implements ClientesDAO {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public List<Cliente> findAll() {

        String query = "select * from clientes";

        List<Cliente> clientes = getJdbcTemplate().query(query, new ClienteMapper());

        return clientes;
    }

    @Override
    public Cliente findById(int codigo) {

        String query = "select * from clientes where codigo = ?";

        Object params [] = {codigo};
        int types [] = {Types.INTEGER};

        Cliente cliente = (Cliente) getJdbcTemplate().queryForObject(query, params, types, new ClienteMapper());

        return cliente;
    }

    @Override
    public void insert(Cliente cliente) {

        String query = "insert into clientes (nombre," +
                                            " apellidos, " + 
                                            " dni, " +
                                            " email, " + 
                                            " telefono, " + 
                                            " direccion, " + 
                                            " vip)" + 
                                            " values (?, ?, ?, ?, ?, ?, ?)";

        Object[] params = {
            cliente.getNombre(),
            cliente.getApellidos(),
            cliente.getEmail(),
            cliente.getDni(),
            cliente.getTelefono(),
            cliente.getDireccion(),
            cliente.isVip()
        };

        final int[] types = {
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.BOOLEAN
        };

        int update = getJdbcTemplate().update(query, params, types);
    }

    @Override
    public void update(Cliente cliente) {

        String query = "update clientes set nombre = ?," +
                                            " apellidos = ?," + 
                                            " dni = ?," +
                                            " direccion = ?," + 
                                            " telefono = ?, " + 
                                            " email = ?, " + 
                                            " vip = ?" + 
                                            " where codigo = ?";

        Object[] params = {
            cliente.getNombre(),
            cliente.getApellidos(),
            cliente.getDni(),
            cliente.getDireccion(),
            cliente.getTelefono(),
            cliente.getEmail(),
            cliente.isVip(),
            cliente.getCodigo()
        };

        final int[] types = {
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.BOOLEAN,
            Types.INTEGER
        };

        int update = getJdbcTemplate().update(query, params, types);
    }

    @Override
    public void delete(int codigo) {

        String query = "delete from clientes where codigo = ?";

        Object[] params = {
            codigo
        };

        final int[] types = {
            Types.INTEGER
        };

        int update = getJdbcTemplate().update(query, params, types);
    }
}
