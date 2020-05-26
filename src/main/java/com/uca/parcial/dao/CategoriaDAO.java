package com.uca.parcial.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.parcial.domain.Categoria;


public interface CategoriaDAO {
	
	public List<Categoria> findAllCategories() throws DataAccessException;

	public void insertCategory(Categoria categoria) throws DataAccessException;
	
}
