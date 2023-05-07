package com.gabriel.imoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.imoney.entity.B2cEntity;

@Repository
public interface B2CRepository extends JpaRepository<B2cEntity, Long> {

}
