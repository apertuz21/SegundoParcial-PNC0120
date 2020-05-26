package com.uca.parcial.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.parcial.domain.Libro;

public interface LibroService {
	
	public List<Libro> findAllBooks() throws DataAccessException;
	
	public void insertBook(Libro libro) throws DataAccessException;
	
}
