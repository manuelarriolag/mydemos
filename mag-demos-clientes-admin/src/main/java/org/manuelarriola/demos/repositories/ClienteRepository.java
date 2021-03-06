
package org.manuelarriola.demos.repositories;

import java.util.List;

import org.manuelarriola.demos.models.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "clientes-api", path = "clientes-api")
public interface ClienteRepository extends MongoRepository<Cliente, String> {

	List<Cliente> findByNombre(@Param("nombre") String nombre);

}
