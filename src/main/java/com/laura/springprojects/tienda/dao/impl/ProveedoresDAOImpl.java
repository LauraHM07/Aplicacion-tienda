// package com.laura.springprojects.tienda.dao.impl;

// import com.laura.springprojects.tienda.dao.ProveedoresDAO;
// import com.laura.springprojects.tienda.model.Proveedor;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.PageImpl;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort.Order;
// import org.springframework.jdbc.core.PreparedStatementCreator;
// import org.springframework.jdbc.core.RowMapper;
// import org.springframework.jdbc.core.support.JdbcDaoSupport;
// import org.springframework.jdbc.support.GeneratedKeyHolder;
// import org.springframework.jdbc.support.KeyHolder;
// import org.springframework.lang.Nullable;
// import org.springframework.stereotype.Repository;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.sql.Types;
// import java.util.List;
// import javax.annotation.PostConstruct;
// import javax.sql.DataSource;

// @Repository
// public class ProveedoresDAOImpl extends JdbcDaoSupport implements ProveedoresDAO {
    
//     @Autowired
//     DataSource dataSource;

//     @PostConstruct
//     private void initialize() {
//         setDataSource(dataSource);
//     }

//     @Override
//     public PageImpl<Proveedor> findAll(Pageable page) {

//         String queryCount = "select count(1) from proveedores";
//         Integer total = getJdbcTemplate().queryForObject(queryCount,Integer.class);


//         Order order = !page.getSort().isEmpty() ? page.getSort().toList().get(0) : Order.by("codigo");

//         String query = "SELECT * FROM proveedores ORDER BY " + order.getProperty() + " "
//         + order.getDirection().name() + " LIMIT " + page.getPageSize() + " OFFSET " + page.getOffset();

//         final List<Proveedor> proveedores = getJdbcTemplate().query(query, new RowMapper<Proveedor>() {

//             @Override
//             @Nullable
//             public Proveedor mapRow(ResultSet rs, int rowNum) throws SQLException {
//                 Proveedor proveedor = new Proveedor();
//                 proveedor.setCodigo(rs.getInt("codigo"));
//                 proveedor.setNombre(rs.getString("nombre"));
//                 proveedor.setApellidos(rs.getString("apellidos"));

//                 return proveedor;
//             }
            
//         });

//         return new PageImpl<Proveedor>(proveedores, page, total);
//     }

//     @Override
//     public Proveedor findById(int codigo) {

//         String query = "select p.* from proveedores p where p.codigo = ?";

//         Object params [] = {codigo};
//         int types [] = {Types.INTEGER};

//         Proveedor proveedor = (Proveedor) getJdbcTemplate().queryForObject(query, params, types, new RowMapper<Proveedor>() {
//             @Override
//             @Nullable
//             public Proveedor mapRow(ResultSet rs, int rowNum) throws SQLException {
//                 Proveedor proveedor = new Proveedor();
//                 proveedor.setCodigo(rs.getInt("codigo"));
//                 proveedor.setNombre(rs.getString("nombre"));
//                 proveedor.setApellidos(rs.getString("apellidos"));

//                 return proveedor;
//             }
//         });

//         return proveedor;
//     }

//     @Override
//     public void insert(Proveedor proveedor) {

//         String query = "insert into proveedores (nombre," +
//                                             " apellidos)" +
//                                             " values (?, ?)";

//         KeyHolder keyHolder = new GeneratedKeyHolder();

//         getJdbcTemplate().update(new PreparedStatementCreator() {

//             @Override
//             public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//                 PreparedStatement ps = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

//                 ps.setString(1, proveedor.getNombre());
//                 ps.setString(2, proveedor.getApellidos());

//                 return ps;
//             }
//         }, keyHolder);

//         proveedor.setCodigo(keyHolder.getKey().intValue());
//     }

//     @Override
//     public void update(Proveedor proveedor) {

//         String query = "update proveedores set nombre = ?," +
//                                             " apellidos = ?" + 
//                                             " where codigo = ?";

//         Object[] params = {
//             proveedor.getNombre(),
//             proveedor.getApellidos(),
//             proveedor.getCodigo()
//         };

//         final int[] types = {
//             Types.VARCHAR,
//             Types.VARCHAR,
//             Types.INTEGER
//         };

//         int update = getJdbcTemplate().update(query, params, types);
//     }

//     @Override
//     public void delete(int codigo) {

//         String query = "delete from proveedores where codigo = ?";

//         Object[] params = {
//             codigo
//         };

//         final int[] types = {
//             Types.INTEGER
//         };

//         int update = getJdbcTemplate().update(query, params, types);
//     }
// }
