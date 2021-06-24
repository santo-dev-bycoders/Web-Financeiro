package org.sambasoft.impl;

import org.sambasoft.model.Finance;
import org.sambasoft.model.Transacts;
import org.sambasoft.services.FinanceService;
import org.sambasoft.services.TransactService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TransactServiceImpl implements TransactService {

	private static final String GET_TRANSACTS_ENDPOINT_URL = "http://localhost:8182/transact/findAll";
	private static final String GET_ROUTE_ENDPOINT_URL =    "http://localhost:8182/transact/findById/";
	private static final String CREATE_TRANSACT_ENDPOINT_URL = "http://localhost:8182/transact/create";
	private static RestTemplate restTemplate = new RestTemplate();



	@Override
	public void create(Transacts transacts) {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForLocation(GET_TRANSACTS_ENDPOINT_URL, transacts, Finance.class);
	}

	@Override
	public Transacts findById(long id) {
		RestTemplate restTemplate = new RestTemplate();
		Transacts transacts = restTemplate.getForObject(GET_ROUTE_ENDPOINT_URL+ id, Transacts.class);
		return transacts;
	}

	@Override
	public List<Transacts> findAll() {
		RestTemplate restTemplate = new RestTemplate();
		List<Transacts> list = restTemplate.getForObject(CREATE_TRANSACT_ENDPOINT_URL, List.class);
		return list;
	}



}
