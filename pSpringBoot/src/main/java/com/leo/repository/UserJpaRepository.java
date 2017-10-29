package com.leo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leo.entity.User;

@Repository("userJpaRepository")
public interface UserJpaRepository extends JpaRepository<User, Serializable> {
	public User findByUsername(String username);
}
