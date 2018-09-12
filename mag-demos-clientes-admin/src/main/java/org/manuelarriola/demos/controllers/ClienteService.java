/**
 * 
 */
package org.manuelarriola.demos.controllers;

import org.manuelarriola.demos.models.Cliente;
import org.manuelarriola.demos.models.ClienteListResponse;

/**
 * Servicio responsable de la persistencia y lógica de negocio de Clientes.
 * 
 * @author manuelarriola
 *
 */
public interface ClienteService {

	ClienteListResponse findAll();
	ClienteListResponse findById(String id);
	ClienteListResponse findByNombre(String nombre);
	ClienteListResponse save(Cliente cliente);
	ClienteListResponse update(Cliente cliente, String id);
	ClienteListResponse delete(String id);

}
