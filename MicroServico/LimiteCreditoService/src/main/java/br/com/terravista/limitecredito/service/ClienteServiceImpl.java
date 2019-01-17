package br.com.terravista.limitecredito.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.terravista.limitecredito.entity.ClienteEntity;
import br.com.terravista.limitecredito.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired private ClienteRepository repository;
	
	public Iterable<ClienteEntity> getClientes() {
		return repository.findAll();
	}

	@Override
	public void save(ClienteEntity cliente) {
		if (cliente.getRisco().equalsIgnoreCase("B")) {
			cliente.setTaxaJuro(BigDecimal.TEN);
		} else if (cliente.getRisco().equalsIgnoreCase("C")) {
			cliente.setTaxaJuro(new BigDecimal(20));
		}
		repository.save(cliente);
	}

}
