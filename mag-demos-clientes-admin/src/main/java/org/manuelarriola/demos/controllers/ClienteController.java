package org.manuelarriola.demos.controllers;

import org.manuelarriola.demos.models.Cliente;
import org.manuelarriola.demos.models.ClienteListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Expone las APIs para administración de clientes.
 * 
 * @author Manuel Arriola
 *
 */
@RestController
//@RequestMapping("/clientes")
@Api("Servicio para administración de clientes")
public class ClienteController {
	

	private static Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	
	@Autowired
	private ClienteService clienteService;
	
		
	/***
	 * Constructor default y único para el controller
	 * 
	 * @param 
	 *  clienteService es el servicio responsable de la lógica de negocio.
	 */
	@Autowired 
	public ClienteController(ClienteService clienteService) {
	     this.clienteService = clienteService;
	}
		
	
	/***
	 * Obtiene la lista de clientes.
	 * 
	 * @return ClienteListResponse La lista de clientes registrados con lps 
	 */
	@ApiOperation(notes = "Obtiene la lista de clientes", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE, value = "")
	@GetMapping(value = "/clientes/")
	public ClienteListResponse getList(){	
		log.debug("getList");
		return clienteService.findAll();
	}
	
	/***
	 * Obtiene el cliente especificado por ID.
	 * 
	 * @return ClienteListResponse Datos del cliente
	 */
	@ApiOperation(notes = "Obtiene el cliente especificado por ID", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE, value = "")
	@GetMapping(value = "/clientes/{id}")
	public ClienteListResponse getById(@PathVariable("id") String id){	
		log.debug("getById: id: " + id);
		return clienteService.findById(id);
	}
	
	
	/***
	 * Obtiene el cliente especificado por NOMBRE.
	 * 
	 * @return ClienteListResponse Datos del cliente
	 */
	@ApiOperation(notes = "Obtiene el cliente especificado por NOMBRE", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE, value = "")
	@RequestMapping(value = "/clientes", method = RequestMethod.GET, params="nombre")
	public ClienteListResponse getByNombre(@RequestParam("nombre") String nombre){	
		log.debug("getByNombre: nombre: " + nombre);
		return clienteService.findByNombre(nombre);
	}
	
	
	/***
	 * Crear el cliente especificado.
	 * 
	 * @return ClienteListResponse Datos del cliente
	 */
	@ApiOperation(notes = "Crear el cliente especificado", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE, value = "")
	@PostMapping(value = "/clientes")
	public ClienteListResponse create(@RequestBody Cliente cliente){	
		log.debug("create: cliente: " + cliente.toString());
		return clienteService.save(cliente);
	}
	
	/***
	 * Actualizar el cliente especificado.
	 * 
	 * @return ClienteListResponse Datos del cliente
	 */
	@ApiOperation(notes = "Actualizar el cliente especificado", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_VALUE, value = "")
	@PutMapping(value = "/clientes/{id}")
	public ClienteListResponse update(@RequestBody Cliente cliente, @PathVariable("id") String id){	
		log.debug("update: cliente: " + cliente.toString());
		log.debug("update: id: " + id);
		return clienteService.update(cliente, id);
	}
	
	
	/***
	 * Eliminar el cliente especificado.
	 * 
	 * @return ClienteListResponse Datos del cliente
	 */
	@ApiOperation(notes = "Eliminar el cliente especificado", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE, value = "")
	@DeleteMapping(value = "/clientes/{id}")
	public ClienteListResponse delete(@PathVariable("id") String id){
		log.debug("delete: id:" + id);
		return clienteService.delete(id);
	}
	
	
	
}
