package com.mateus.practical.homeops.repository;

import java.util.List;
import com.mateus.practical.homeops.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}