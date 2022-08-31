package com.springboot.models.entitys;

public class Cliente {
 //Atributos
	
	private int idcliente;
	private String nombre;
	private String apellido;
	private String correo;
	
	
	//Constructores
	public Cliente() {
		
	}

	public Cliente(int idcliente, String nombre, String apellido, String correo) {
		super();
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}

	 //Metodos get y set
	
	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
	
	
}
