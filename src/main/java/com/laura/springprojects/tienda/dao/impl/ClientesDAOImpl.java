package com.laura.springprojects.tienda.dao.impl;

import com.laura.springprojects.tienda.dao.ClientesDAO;
import com.laura.springprojects.tienda.dao.mappers.ClienteMapper;
import com.laura.springprojects.tienda.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public PageImpl<Cliente> findAll(Pageable page) {

        String queryCount = "select count(1) from clientes";
        Integer total = getJdbcTemplate().queryForObject(queryCount,Integer.class);


        Order order = !page.getSort().isEmpty() ? page.getSort().toList().get(0) : Order.by("codigo");

        String query = "SELECT * FROM clientes ORDER BY " + order.getProperty() + " "
        + order.getDirection().name() + " LIMIT " + page.getPageSize() + " OFFSET " + page.getOffset();

        final List<Cliente> clientes = getJdbcTemplate().query(query, new RowMapper<Cliente>() {

            @Override
            @Nullable
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setEmail(rs.getString("email"));
                cliente.setDni(rs.getString("dni"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setVip(rs.getBoolean("vip"));
                cliente.setDireccion(rs.getString("direccion"));

                return cliente;
            }
            
        });

        return new PageImpl<Cliente>(clientes, page, total);

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
                                            " email, " +
                                            " dni, " +
                                            " telefono, " + 
                                            " vip, " + 
                                            " direccion)" + 
                                            " values (?, ?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        getJdbcTemplate().update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, cliente.getNombre());
                ps.setString(2, cliente.getApellidos());
                ps.setString(3, cliente.getEmail());
                ps.setString(4, cliente.getDni());
                ps.setString(5, cliente.getTelefono());
                ps.setBoolean(6, cliente.isVip());
                ps.setString(7, cliente.getDireccion());

                return ps;
            }
        }, keyHolder);

        cliente.setCodigo(keyHolder.getKey().intValue());
    }

    @Override
    public void update(Cliente cliente) {

        String query = "update clientes set nombre = ?," +
                                            " apellidos = ?," + 
                                            " email = ?, " + 
                                            " dni = ?," +
                                            " telefono = ?, " +
                                            " vip = ?," + 
                                            " direccion = ?" + 
                                            " where codigo = ?";

        Object[] params = {
            cliente.getNombre(),
            cliente.getApellidos(),
            cliente.getEmail(),
            cliente.getDni(),
            cliente.getTelefono(),
            cliente.isVip(),
            cliente.getDireccion(),
            cliente.getCodigo()
        };

        final int[] types = {
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.VARCHAR,
            Types.BOOLEAN,
            Types.VARCHAR,
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
