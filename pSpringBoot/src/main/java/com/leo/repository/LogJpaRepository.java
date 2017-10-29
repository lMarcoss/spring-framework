package com.leo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leo.entity.Log;

@Repository("logJpaRepository")
public interface LogJpaRepository extends JpaRepository<Log, Serializable> {
	
}
