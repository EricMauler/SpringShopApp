package fr.fms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@Service
public class IBusinessImpl implements IBusiness {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}

	@Override
	public Article save(String name, String brand, double price, long idCat) {
		return articleRepository.save(new Article(name, brand, price, idCat));

	}

	public void modifyArticle(long id, String name, String brand, double price, long idCat) {
		articleRepository.save(new Article(id, name, brand, price, idCat));

	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public void deleteArticle(long id) {
		articleRepository.deleteById((long) id);

	}

	public void saveCategory(long id, String name) {
		categoryRepository.save(new Category(id, name));
		
	}

	public List<Article> readOneArticle(String description) {
		return articleRepository.findByDescription(description);
		
	}

	public void modifyCategory(long id, String name) {
		categoryRepository.save(new Category(id, name));
		
	}

	@Override
	public Category saveCategory(String name) {
		return categoryRepository.save(new Category(name));
		
	}


}
