package com.mtec.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtec.model.Editorial;

public interface IEditorialRepository extends JpaRepository<Editorial, Long> {

}
