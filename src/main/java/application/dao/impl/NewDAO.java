package application.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import application.dao.INewDAO;
import application.mapper.NewMapper;
import application.model.New;

@Repository
public class NewDAO extends AbstractDAO<New> implements INewDAO {

	@Override
	public List<New> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM news ");
		return query(sql.toString(), new NewMapper());

	}

}
