package com.gabriel.imoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.imoney.entity.C2bEntity;

@Repository
public interface C2BRepository extends JpaRepository<C2bEntity, Long>{

}
