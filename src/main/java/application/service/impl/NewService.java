package application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dao.INewDAO;
import application.model.New;
import application.service.INewService;


@Service
public class NewService implements INewService {

	@Autowired
	private INewDAO newDAO;


	@Override
	public List<New> findAll() {
		return newDAO.findAll();
	}

}
