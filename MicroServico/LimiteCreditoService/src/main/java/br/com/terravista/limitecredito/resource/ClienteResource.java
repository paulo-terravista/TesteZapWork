package br.com.terravista.limitecredito.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.terravista.limitecredito.entity.ClienteEntity;
import br.com.terravista.limitecredito.service.ClienteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
	
	
	@Autowired private ClienteService clienteService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<ClienteEntity> getAll() {
		return clienteService.getClientes();
	}

	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void save(@RequestBody(required=true) ClienteEntity cliente) {
		clienteService.save(cliente);
	}
	
	
}
