package com.uca.parcial.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_libro")
	private Integer codigo;
	
	@Column(name = "s_titulo")
	@NotEmpty(message = "El campo no puede estar vacio")
	@Size(max = 500, message = "El campo no puede tener mas de 500 caracteres")
	private String titulo;
	
	@Column(name = "s_autor")
	@NotEmpty(message = "El campo no puede estar vacio")
	@Size(max = 150, message="El campo no puede tener mas de 150 caracteres")
	private String autor;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_categoria")
	private Categoria categoria;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "f_ingreso")
	private Date fecha;
	
	@Column(name = "b_estado")
	private Boolean estado;
	
	@Column(name = "s_isbn")
	@NotEmpty(message = "El campo no puede estar vacio")
	@Size(max = 10, message="El campo no puede tener mas de 10 caracteres")
	private String isbn;
	
	public Libro() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo (Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Date getFecha() {
		return fecha;
	}
	
	public String getFechaDelegate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String strDate= formatter.format(fecha);
		return strDate;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	
	

	
	
	
	
}