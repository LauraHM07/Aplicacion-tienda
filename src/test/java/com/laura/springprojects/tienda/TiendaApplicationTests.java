package com.laura.springprojects.tienda;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.laura.springprojects.tienda.repository.UsuarioRepository;
import com.laura.springprojects.tienda.model.Permiso;
import com.laura.springprojects.tienda.model.Usuario;
import com.laura.springprojects.tienda.repository.PermisoRepository;

@SpringBootTest
class TiendaApplicationTests {

	@Autowired
	UsuarioRepository userRepository;

	@Autowired
	PermisoRepository permissionRepository;

	@Autowired
	PasswordEncoder encoder;

	@Test
	void crearUsuariosTest() {
		Usuario usuario1 = new Usuario();
		usuario1.setCodigo(1);
		usuario1.setNombre("usuario1");
		usuario1.setPassword(encoder.encode("1111"));
		usuario1.setEmail("user1@gmail.com");

		Usuario usuario2 = new Usuario();
		usuario2.setCodigo(2);
		usuario2.setNombre("usuario2");
		usuario2.setPassword(encoder.encode("2222"));
		usuario2.setEmail("user2@gmail.com");

		Usuario usuario3 = new Usuario();
		usuario3.setCodigo(3);
		usuario3.setNombre("usuario3");
		usuario3.setPassword(encoder.encode("3333"));
		usuario3.setEmail("user3@gmail.com");

		Usuario usuario4 = new Usuario();
		usuario4.setCodigo(4);
		usuario4.setNombre("usuario4");
		usuario4.setEmail("user4@gmail.com");
		usuario4.setPassword(encoder.encode("4444"));

		Permiso permisoAdmin = new Permiso();
		permisoAdmin.setCodigo(1);
		permisoAdmin.setNombre("ADMIN");

		Permiso permisoUsuario = new Permiso();
		permisoUsuario.setCodigo(2);
		permisoUsuario.setNombre("USER");

		Permiso permisoCliente = new Permiso();
		permisoCliente.setCodigo(3);
		permisoCliente.setNombre("CLIENTE");

		Permiso permisoCesta = new Permiso();
		permisoCesta.setCodigo(4);
		permisoCesta.setNombre("CESTA");

		List<Permiso> permisosTodos = new ArrayList<Permiso>();
		permisosTodos.add(permisoAdmin);
		permisosTodos.add(permisoUsuario);
		permisosTodos.add(permisoCliente);
		permisosTodos.add(permisoCesta);

		List<Permiso> permisosPedidos = new ArrayList<Permiso>();
		permisosPedidos.add(permisoUsuario);
		permisosPedidos.add(permisoCesta);

		List<Permiso> permisosClientes = new ArrayList<Permiso>();
		permisosClientes.add(permisoUsuario);
		permisosClientes.add(permisoCliente);
		permisosClientes.add(permisoCesta);

		usuario1.setPermissions(permisosTodos);
		usuario2.setPermissions(permisosPedidos);
		usuario3.setPermissions(permisosClientes);

		permisoAdmin = permissionRepository.save(permisoAdmin);
		permisoUsuario = permissionRepository.save(permisoUsuario);
		permisoCliente = permissionRepository.save(permisoCliente);
		permisoCesta = permissionRepository.save(permisoCesta);

		userRepository.save(usuario1);
		Usuario saveUsuario2 = userRepository.save(usuario2);
		userRepository.save(usuario3);
		userRepository.save(usuario4);

		assertTrue(usuario2.getPassword().equalsIgnoreCase(saveUsuario2.getPassword()));

	}

}
