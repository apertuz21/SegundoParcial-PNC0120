package com.uca.parcial.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="cat_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_categoria")
	private Integer codigo;
	
	@Column(name="s_categoria")
	@NotEmpty(message="El campo no puede estar vacio")
	@Size(max=50,message="El campo no puede tener mas de 50 caracteres")
	private String nameCategoria;

	@OneToMany(mappedBy="categoria", fetch = FetchType.EAGER)
	private List<Libro> libros;
	
	public Categoria() {
		super();

	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNameCategoria() {
		return nameCategoria;
	}

	public void setNameCategoria(String nameCategoria) {
		this.nameCategoria = nameCategoria;
	}

	
	
	
}