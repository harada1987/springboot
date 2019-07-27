package com.harada.springboot.udemy.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harada.springboot.udemy.domain.Cliente;
import com.harada.springboot.udemy.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Cliente> listar(){
		return service.buscar();
	}
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		Cliente cliente = service.buscar(id);
		return ResponseEntity.ok().body(cliente);
	}

}
