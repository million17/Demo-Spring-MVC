	package application.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import application.dao.ICategoryDAO;
import application.model.Category;
import application.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryDAO categoryDao;

	@Override
	public List<Category> findAll() {

		return categoryDao.findAll();
	}

	@Override
	public Category update(Category update) {

		return null;
	}

	@Override
	public void delete(Long categoryId) {
		categoryDao.delete(categoryId);

	}

	@Override
	public Category save(Category categorys) {
		categorys.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		categorys.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		categorys.setModifiedBy("");
		categorys.setCreatedBy("");
		Long categoryId = categoryDao.save(categorys);
		return categoryDao.findOne(categoryId);
	}

	@Override
	public Category findOne(Long categoryId) {

		return categoryDao.findOne(categoryId);
	}

}
