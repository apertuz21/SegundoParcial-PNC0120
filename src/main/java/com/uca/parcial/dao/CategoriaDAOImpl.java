package com.uca.parcial.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.parcial.domain.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {
	
	@PersistenceContext(unitName="parcial")
	private EntityManager entityManager;
	
	@Override
	public List<Categoria> findAllCategories() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from public.cat_categoria");
		Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
		List<Categoria> categorias = query.getResultList();
		
		return categorias;
	}
	
	@Override
	@Transactional
	public void insertCategory(Categoria categoria) throws DataAccessException {
		try {
			if(categoria.getCodigo() == null)
				entityManager.persist(categoria);
			else {
				entityManager.merge(categoria);
				entityManager.flush();
			}
				
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
