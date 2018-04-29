package com.lchinarelli.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lchinarelli.cursomc.domain.Cliente;
import com.lchinarelli.cursomc.repositories.ClienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
 
	public Cliente find(Integer id){
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.lchinarelli.cursomc.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
}
