package fr.fms.business;

import java.util.List;

import fr.fms.entities.Article;
import fr.fms.entities.Category;

public interface IBusiness {

	public List<Article> getAllArticles();
	
	public Article save(String name, String brand, double price);
	
	public List<Category> getAllCategories();
	
	//public Article save(String name, String brand, double price, int id);
	
	public void deleteArticle (long id);

	public void modifyArticle(long id, String name, String brand, double price);

	Article save(String name, String brand, double price, Category idCat);

	Article save(String name, String brand, double price, long idCat);
	
	public void saveCategory(String name);

	public List<Article> readOneArticle(String description); }
