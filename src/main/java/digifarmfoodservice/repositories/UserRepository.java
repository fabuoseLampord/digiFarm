package digifarmfoodservice.repositories;

import digifarmfoodservice.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query
    Optional<User> findByUsername(String username);
}
