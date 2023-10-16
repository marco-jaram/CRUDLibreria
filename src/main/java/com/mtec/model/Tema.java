package com.mtec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tema {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTema;
    private String nombreTema;
    
    
	public Long getIdTema() {
		return idTema;
	}
	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}
	public String getNombreTema() {
		return nombreTema;
	}
	public void setNombreTema(String nombreTema) {
		this.nombreTema = nombreTema;
	}
	public Tema(Long idTema, String nombreTema) {
		super();
		this.idTema = idTema;
		this.nombreTema = nombreTema;
	}
	public Tema() {
		super();
	}
    
    
}
