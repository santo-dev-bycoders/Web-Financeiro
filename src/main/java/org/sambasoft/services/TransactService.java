package org.sambasoft.services;


import org.sambasoft.model.Finance;
import org.sambasoft.model.Transacts;

import java.util.List;

public interface TransactService {

	public void create(Transacts transacts) ;

	public Transacts findById(long id) ;

	public List<Transacts> findAll();

}
