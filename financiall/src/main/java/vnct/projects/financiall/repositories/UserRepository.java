package vnct.projects.financiall.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vnct.projects.financiall.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
