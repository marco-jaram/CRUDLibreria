package com.mtec.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtec.model.Tema;

public interface ITemaRepository extends JpaRepository<Tema, Long> {

}
