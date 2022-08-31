package com.springboot.models.dao;

import java.util.List;

import com.springboot.models.entitys.Cliente;

public interface IClienteDao {
//Metodos CRUD
	
	public List<Cliente>listar();
	public int guardar(Cliente cliente);
	public Cliente buscarID(long id);
	public int actualizar(Cliente cliente);
	public int borrar (long id);
}
