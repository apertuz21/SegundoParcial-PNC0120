package com.uca.parcial.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.parcial.domain.Categoria;


public interface CategoriaService {
	
	public List<Categoria> findAllCategories() throws DataAccessException;

	public void insertCategory(Categoria categoria) throws DataAccessException;
	
}
