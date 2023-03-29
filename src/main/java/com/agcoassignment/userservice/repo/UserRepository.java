package com.agcoassignment.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.agcoassignment.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}