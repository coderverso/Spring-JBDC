package com.springboot.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.models.entitys.Cliente;

@Repository
public class ClienteDaoImpl  implements IClienteDao{

	@Autowired
	private JdbcTemplate jdbctTemplate;
	
	
	@Override
	public List<Cliente> listar() {
		String sql="select *from cliente";
		List<Cliente>lista=jdbctTemplate.query(sql, BeanPropertyRowMapper.newInstance(Cliente.class));
		return lista;
	}

	@Override
	public int guardar(Cliente cliente) {
		String sql="insert into cliente(nombre,apellido,correo)values(?,?,?)";
		return jdbctTemplate.update(sql,cliente.getNombre(),cliente.getApellido(),cliente.getCorreo());
	}

	@Override
	public Cliente buscarID(long id) {
		String sql="select *from cliente where idcliente=?";
		Cliente cliente=jdbctTemplate.queryForObject(sql, new Object[] {id},
				BeanPropertyRowMapper.newInstance(Cliente.class));
		return cliente;
	}

	@Override
	public int actualizar(Cliente cliente) {
		String sql="update cliente set nombre=?,apellido=?,correo=? where idcliente=?";
		return jdbctTemplate.update(sql,cliente.getNombre(),cliente.getApellido(),cliente.getCorreo()
				,cliente.getIdcliente());
	
	}

	@Override
	public int borrar(long id) {
		String sql="delete from cliente where idcliente=?";
		return jdbctTemplate.update(sql,id);
	}

}
