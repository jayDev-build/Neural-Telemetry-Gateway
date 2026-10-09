package com.example.Neural_Telemetry_Gateway.Repository;

import com.example.Neural_Telemetry_Gateway.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findBymailaddress(String mailaddress);

    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);
}