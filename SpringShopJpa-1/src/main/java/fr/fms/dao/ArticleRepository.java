package fr.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.fms.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	public List<Article> findByBrand(String brand);

	public List<Article> findByBrandAndPriceGreaterThan(String brand, double price);

	@Query("select A from Article A where A.brand like %:x% and A.price > :y")
	public List<Article> searchArticles(@Param("x") String kw, @Param("y") double price);

	public List<Article> findByDescriptionAndBrand(String description, String brand);

	public List<Article> findByDescription(String description);
	
}
