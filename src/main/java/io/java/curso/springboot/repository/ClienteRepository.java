package io.java.curso.springboot.repository;

import io.java.curso.springboot.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class ClienteRepository {

//    private static String SELECT_ALL = "select * from cliente";
//    private static String UPDATE = "update cliente set nome = ? where id = ?";
//    private static String DELETE = "delete from cliente where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
    }
//
//    public List<Cliente> buscarPorNome(String nome){
//        return jdbcTemplate.query(SELECT_ALL.concat(" where nome like '%"+nome+"%'"),getClienteRowMapper());
//    }
//
//    public List<Cliente> listarClientes() {
//        return jdbcTemplate.query(SELECT_ALL, getClienteRowMapper());
//    }
//
//    public Cliente atualizar(Cliente cliente) {
//        jdbcTemplate.update(UPDATE, new Object[]{cliente.getNome(),cliente.getId()});
//        return cliente;
//    }
//
//    public void deletar(Cliente cliente){
//        deletar(cliente.getId());
//    }
//    public void deletar(Integer id){
//        jdbcTemplate.update(DELETE,new Object[]{id});
//    }
//
//    private RowMapper<Cliente> getClienteRowMapper() {
//        return new RowMapper<Cliente>() {
//            @Override
//            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
//                Integer id = resultSet.getInt("id");
//                String nome = resultSet.getString("nome");
//                return new Cliente(id, nome);
//            }
//        };
//    }
}
