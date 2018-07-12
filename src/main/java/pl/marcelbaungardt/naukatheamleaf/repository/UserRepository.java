package pl.marcelbaungardt.naukatheamleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.marcelbaungardt.naukatheamleaf.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
