package fr.fms.business;

import java.util.List;

import fr.fms.entities.Article;
import fr.fms.entities.Category;

public interface IBusiness {

	public List<Article> getAllArticles();
	
	public List<Category> getAllCategories();
	
	public void deleteArticle (long id);

	public void modifyArticle(long id, String name, String brand, double price, long idCat);

	public Article save(String name, String brand, double price, long idCat);
	
	public Category saveCategory(String name);

	public List<Article> readOneArticle(String description); 
	
    public void modifyCategory(long id, String name);
}
