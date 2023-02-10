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
		Usuario u1 = new Usuario();
		u1.setCodigo(1);
		u1.setNombre("usuario1");
		u1.setPassword(encoder.encode("1111"));
		u1.setEmail("user1@gmail.com");

		Usuario u2 = new Usuario();
		u2.setCodigo(2);
		u2.setNombre("usuario2");
		u2.setPassword(encoder.encode("2222"));
		u2.setEmail("user2@gmail.com");

		Usuario u3 = new Usuario();
		u3.setCodigo(3);
		u3.setNombre("usuario3");
		u3.setPassword(encoder.encode("3333"));
		u3.setEmail("user3@gmail.com");

		Usuario u4 = new Usuario();
		u4.setCodigo(4);
		u4.setNombre("usuario4");
		u4.setEmail("user4@gmail.com");
		u4.setPassword(encoder.encode("4444"));

		Permiso p1 = new Permiso();
		p1.setCodigo(1);
		p1.setNombre("ADMIN");

		Permiso p2 = new Permiso();
		p2.setCodigo(2);
		p2.setNombre("USER");

		Permiso p3 = new Permiso();
		p3.setCodigo(3);
		p3.setNombre("CLIENTE");

		Permiso p4 = new Permiso();
		p4.setCodigo(4);
		p4.setNombre("CESTA");

		List<Permiso> permisos1 = new ArrayList<Permiso>();
		permisos1.add(p1);
		permisos1.add(p2);
		permisos1.add(p3);
		permisos1.add(p4);

		List<Permiso> permisos2 = new ArrayList<Permiso>();
		permisos2.add(p2);
		permisos2.add(p4);

		List<Permiso> permisos3 = new ArrayList<Permiso>();
		permisos3.add(p2);
		permisos3.add(p3);
		permisos3.add(p4);

		u1.setPermissions(permisos1);
		u2.setPermissions(permisos2);
		u3.setPermissions(permisos3);

		p1 = permissionRepository.save(p1);
		p2 = permissionRepository.save(p2);
		p3 = permissionRepository.save(p3);
		p4 = permissionRepository.save(p4);

		userRepository.save(u1);
		Usuario saveUsuario2 = userRepository.save(u2);
		userRepository.save(u3);
		userRepository.save(u4);

		assertTrue(u2.getPassword().equalsIgnoreCase(saveUsuario2.getPassword()));

	}

}
