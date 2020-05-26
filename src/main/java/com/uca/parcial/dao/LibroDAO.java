package com.uca.parcial.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.parcial.domain.Libro;

public interface LibroDAO {
	
	public List<Libro> findAllBooks() throws DataAccessException;
	
	public void insertBook(Libro libro) throws DataAccessException;
	
}
