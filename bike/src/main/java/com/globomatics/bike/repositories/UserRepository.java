package com.globomatics.bike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globomatics.bike.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
