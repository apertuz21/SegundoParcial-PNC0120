package com.uca.parcial.controller;

import java.util.Date;
import java.util.List;

import java.text.SimpleDateFormat; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.parcial.domain.Libro;
import com.uca.parcial.domain.Categoria;
import com.uca.parcial.service.LibroService;

import com.uca.parcial.service.CategoriaService;

import javax.validation.Valid;

@Controller
public class MainController {
	@Autowired
    private LibroService libroService;
	@Autowired
	private CategoriaService categoriaService;
	
	
	@RequestMapping("/index")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView ingresarCategoria () {
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		mav.addObject("categoria", categoria);
		mav.setViewName("ingresar-categoria");
		return mav;
	}
	
	@RequestMapping("/ingresarLibro")
	public ModelAndView ingresarLibro () {
		ModelAndView mav = new ModelAndView();
		List<Categoria> categorias = null;
		try {
			categorias = categoriaService.findAllCategories();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("categorias", categorias);
		mav.addObject("libro", new Libro());
		mav.setViewName("ingresar-libro");
		return mav;
	}
	
	@RequestMapping("/verLibros")
	public ModelAndView verLibros () {
		ModelAndView mav = new ModelAndView();
		List<Libro> libroList = null;
        try {
        	libroList = libroService.findAllBooks();
        }catch (Exception e){
            e.printStackTrace();
        }
		mav.addObject("libros", libroList);
		mav.setViewName("libros");
		return mav;
	}
	
	@PostMapping("/insertCategoria")
	public ModelAndView insertCategoria (@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("ingresar-categoria");
		} else {
			try {
				categoriaService.insertCategory(categoria);
				String msg = "Categoria ingresada con éxito"; 
				mav.addObject("message", msg);
				mav.setViewName("index");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
 
		return mav;
		
	}
	
	@PostMapping("/insertLibro")
	public ModelAndView insertLibro (@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("ingresar-libro");
		} else {
			Date date = new Date();

			libro.setFecha(date);
			
			try {
				libroService.insertBook(libro);
				String msg = "Libro ingresado con éxito"; 
				mav.addObject("message", msg);
				mav.setViewName("index");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
 
		return mav;
		
	}

	
}
