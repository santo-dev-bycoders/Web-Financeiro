package org.sambasoft.impl;

import org.sambasoft.model.Finance;
import org.sambasoft.services.FinanceService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FinancaServiceImpl implements FinanceService {

	private static final String GET_FINANCES_ENDPOINT_URL = "http://localhost:8182/finance/findAll";
	private static final String GET_ROUTE_ENDPOINT_URL =    "http://localhost:8182/finance/findById/";
	private static final String CREATE_ROUTE_ENDPOINT_URL = "http://localhost:8182/finance/create";
	private static final String UPDATE_ROUTE_ENDPOINT_URL = "http://localhost:8182/finance/update";
	private static final String DELETE_ROUTE_ENDPOINT_URL = "http://localhost:8182/finance/delete";
	private static RestTemplate restTemplate = new RestTemplate();

	@Override
	public void delete(long id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(DELETE_ROUTE_ENDPOINT_URL+"/" + id);
	}

	@Override
	public void create(List<Finance> listFinance) {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForLocation(CREATE_ROUTE_ENDPOINT_URL, listFinance, Finance.class);
	}

	@Override
	public Finance findById(long id) {
		RestTemplate restTemplate = new RestTemplate();
		Finance finance = restTemplate.getForObject(GET_ROUTE_ENDPOINT_URL+ id, Finance.class);
		return finance;
	}

	@Override
	public List<Finance> findAll() {
		RestTemplate restTemplate = new RestTemplate();
		List<Finance> listFinances = restTemplate.getForObject(GET_FINANCES_ENDPOINT_URL, List.class);
		return listFinances;
	}




}
