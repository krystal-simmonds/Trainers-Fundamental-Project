package com.qa.trainers.repo;

import com.qa.trainers.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepository extends JpaRepository<User, Long> {
}
