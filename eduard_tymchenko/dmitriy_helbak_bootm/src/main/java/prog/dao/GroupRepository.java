package prog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import prog.domain.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
