package pl.marcelbaungardt.naukatheamleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.marcelbaungardt.naukatheamleaf.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
