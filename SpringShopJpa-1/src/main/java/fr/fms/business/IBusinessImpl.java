package fr.fms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@Service
public class IBusinessImpl implements IBusiness{

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}
	@Override
	public Article save(String name, String brand, double price) {
		return articleRepository.save(new Article(name, brand, price));
		
	}
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
}
	
