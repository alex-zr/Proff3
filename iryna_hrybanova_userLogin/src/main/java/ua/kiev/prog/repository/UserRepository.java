package ua.kiev.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
