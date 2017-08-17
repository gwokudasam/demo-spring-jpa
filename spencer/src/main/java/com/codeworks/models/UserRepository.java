package com.codeworks.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : gwokudasam
 * @Date : 17/8/2017
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
