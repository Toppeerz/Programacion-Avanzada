package co.edu.uniquindio.proyecto.test;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.GeneroPersona;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    @Sql("classpath:usuarios.sql")
    public void registrarUsuarioTest(){

        Ciudad ciudad = ciudadRepo.findById(1).orElse(null);

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "1717171");
        telefonos.put("celular", "9828298");

        Usuario usuario = new Usuario("123","Pepito",LocalDate.now(),GeneroPersona.MASCULINO,"pepito@mail.com",telefonos,ciudad);


//Guardamos el registro
        Usuario guardado = usuarioRepo.save(usuario);
        System.out.println(usuario);
//Comprobamos que si haya quedado
        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void eliminarUsuarioTest(){

//Primero lo buscamos
        Usuario encontrado = usuarioRepo.findById("123").orElse(null);
//Luego lo eliminamos
        usuarioRepo.delete(encontrado);
//Por último, verificamos que si haya quedado borrado
        Usuario buscado = usuarioRepo.findById("111").orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void actualizarUsuarioTest(){

        Usuario usuarioGuardado = usuarioRepo.findById("124").orElse(null);

        usuarioGuardado.setEmail("maria_correonuevo@email.com");

        usuarioRepo.save(usuarioGuardado);

        Usuario buscado = usuarioRepo.findById("124").orElse(null);
        Assertions.assertEquals("maria_correonuevo@email.com", buscado.getEmail());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarUsuariosTest() {
//Obtenemos la lista de todos los usuarios
        List<Usuario> usuarios = usuarioRepo.findAll();
//Imprimimos la lista
        usuarios.forEach(u -> System.out.println(u));

        Assertions.assertEquals(3,usuarios.size());

    }

}