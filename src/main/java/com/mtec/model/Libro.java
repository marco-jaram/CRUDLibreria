package com.mtec.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;
    private String titulo;
    
    @ManyToOne
    @JoinColumn(name = "idAutor")
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "idEditorial")
    private Editorial editorial;
    @ManyToOne
    @JoinColumn(name = "idTema")
    private Tema tema;
    private Long existencia;
    private BigDecimal precio;
    
    
	public Long getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(Long idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Long getExistencia() {
		return existencia;
	}
	public void setExistencia(Long existencia) {
		this.existencia = existencia;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Libro(Long idLibro, String titulo, Autor autor, Editorial editorial, Tema tema, Long existencia,
			BigDecimal precio) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.tema = tema;
		this.existencia = existencia;
		this.precio = precio;
	}
	public Libro() {
		super();
	}
    

}
