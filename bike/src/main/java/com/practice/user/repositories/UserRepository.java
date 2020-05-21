package com.practice.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.user.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
