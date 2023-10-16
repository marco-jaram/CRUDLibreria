package com.mtec.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtec.model.Autor;

public interface IAutorRepository extends JpaRepository<Autor, Long>{

}
