package com.uca.parcial.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.parcial.dao.CategoriaDAO;
import com.uca.parcial.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	CategoriaDAO categoriaDAO;
	
	@Override
	public List<Categoria> findAllCategories() throws DataAccessException {
		return categoriaDAO.findAllCategories();
	}
	
	@Override
	@Transactional
	public void insertCategory(Categoria categoria) throws DataAccessException {
		categoriaDAO.insertCategory(categoria);
	}
	
}
