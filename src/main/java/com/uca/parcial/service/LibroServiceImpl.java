package com.uca.parcial.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.parcial.dao.LibroDAO;
import com.uca.parcial.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService {
	
	@Autowired
	LibroDAO libroDAO;
	
	@Override
	public List<Libro> findAllBooks() throws DataAccessException {
		return libroDAO.findAllBooks();
	}
	
	@Override
	@Transactional
	public void insertBook(Libro libro) throws DataAccessException {
		libroDAO.insertBook(libro);
	}
	
}
