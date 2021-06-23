package org.sambasoft.services;


import org.sambasoft.model.Finance;

import java.util.List;

public interface FinanceService {

	public void delete(long id) ;

	public void update(Finance finance);

	public void create(List<Finance> listFinance) ;

	public Finance findById(long id) ;

	public List<Finance> findAll();

}
