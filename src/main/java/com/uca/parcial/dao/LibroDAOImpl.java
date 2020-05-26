package com.uca.parcial.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.parcial.domain.Libro;


@Repository
public class LibroDAOImpl implements LibroDAO{
	@PersistenceContext(unitName="parcial")
	private EntityManager entityManager;

	@Override
	public List<Libro> findAllBooks() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
		List<Libro> libros = query.getResultList();
		
		return libros;
	}
	
	
	@Override
	@Transactional
	public void insertBook(Libro libro) throws DataAccessException {
		try {
			if(libro.getCodigo() == null)
				entityManager.persist(libro);
			else {
				entityManager.merge(libro);
				entityManager.flush();
			}
				
		} catch (Throwable e) {
			e.printStackTrace();
		}		
		
	}
	
	
	
	
}