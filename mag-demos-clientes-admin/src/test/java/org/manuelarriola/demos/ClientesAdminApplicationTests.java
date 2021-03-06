package org.manuelarriola.demos;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.manuelarriola.demos.models.Cliente;
import org.manuelarriola.demos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientesAdminApplicationTests {

    @Autowired
    ClienteRepository repository;

    Cliente patricia, vania, yahir;

    @Before
    public void setUp() {

        repository.deleteAll();

        patricia = repository.save(new Cliente("Patricia", "Arredondo Macedo", "Coyoacán, CDMX"));
        vania = repository.save(new Cliente("Vania Marely", "Arriola Arredondo", "Tlalpan, CDMX"));
        yahir = repository.save(new Cliente("Yahir", "Arriola Arredondo", "Tlalnepantla, EDO MEX"));
    }

    @Test
    public void setsIdOnSave() {

    	Cliente isai = repository.save(new Cliente("Manuel Isai", "Arriola Arredondo", "Tlalnepantla, EDO MEX"));

        assertThat(isai.getId()).isNotNull();
    }

    @Test
    public void findsByLastName() {

        List<Cliente> result = repository.findByNombre("Yahir");

        assertThat(result).hasSize(1).extracting("apellidos").contains("Arriola Arredondo");
    }

    @Test
    public void findsByExample() {

    	Cliente probe = new Cliente(null, "Arriola Arredondo", null);

        List<Cliente> result = repository.findAll(Example.of(probe));

        assertThat(result).hasSize(2).extracting("nombre").contains("Vania Marely", "Yahir");
    }

}
