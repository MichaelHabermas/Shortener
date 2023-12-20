package shortener.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shortener.entities.Hello;

@Repository
public interface HelloRepository extends JpaRepository<Hello, Long> {
}
