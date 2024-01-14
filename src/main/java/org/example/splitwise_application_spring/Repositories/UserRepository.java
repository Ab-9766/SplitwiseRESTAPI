package org.example.splitwise_application_spring.Repositories;

import org.example.splitwise_application_spring.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    User save(User entity);

    @Override
    Optional<User> findById(Long aLong);

}
