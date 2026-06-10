package com.Project.Project11.repository;
import com.Project.Project11.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
