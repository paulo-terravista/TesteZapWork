package br.com.terravista.limitecredito.service;

import br.com.terravista.limitecredito.entity.ClienteEntity;


public interface ClienteService {
	
	Iterable<ClienteEntity> getClientes();

	void save(ClienteEntity cliente);

}
