package com.mtec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Editorial {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEditorial;
    private String nombreEditorial;
    private String pais;
	public Long getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(Long idEditorial) {
		this.idEditorial = idEditorial;
	}
	public String getNombreEditorial() {
		return nombreEditorial;
	}
	public void setNombreEditorial(String nombreEditorial) {
		this.nombreEditorial = nombreEditorial;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Editorial(Long idEditorial, String nombreEditorial, String pais) {
		super();
		this.idEditorial = idEditorial;
		this.nombreEditorial = nombreEditorial;
		this.pais = pais;
	}
	public Editorial() {
		super();
	}
    
    
	
    

}
