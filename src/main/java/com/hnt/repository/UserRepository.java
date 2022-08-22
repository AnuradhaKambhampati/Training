package com.hnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hnt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
