package shortener.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shortener.entities.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    public Url findByShortCode(String shortcode);
}
