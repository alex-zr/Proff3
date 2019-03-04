package prog.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import prog.domain.User;




public interface UserRepository extends JpaRepository<User, Long> {



}
