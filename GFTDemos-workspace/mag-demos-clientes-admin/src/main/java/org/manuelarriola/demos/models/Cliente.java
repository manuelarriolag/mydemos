package org.manuelarriola.demos.models;

import org.springframework.data.annotation.Id;


/**
 * 
 * Clase para registrar la información
 * del objeto Cliente.
 * 
 * Cliente representa el objeto principal que se administra
 * en el presente Micro-servicio.
 *
 * @author Manuel Arriola
 *
 */
public class Cliente {
	
	@Id 
	private String id;
	
	private String nombre;
	private String apellidos;
	private String domicilio;
		

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public Cliente(String nombre, String apellidos, String domicilio) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.domicilio = domicilio;
	}
	
	
    @Override
    public String toString() {
        return String.format(
                "Cliente[id=%s, nombre='%s', apellidos='%s', domicilio='%s']",
                getId(), nombre, apellidos, domicilio);
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
