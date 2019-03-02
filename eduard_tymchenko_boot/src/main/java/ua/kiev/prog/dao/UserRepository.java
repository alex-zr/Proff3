package ua.kiev.prog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.domain.User;
//Антон, цей рядок мав написати ти, але без нього я не могла писати свій.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
