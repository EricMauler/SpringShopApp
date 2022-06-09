package fr.fms;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.business.IBusinessImpl;
import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringShopJpa1Application implements CommandLineRunner {
	
	@Autowired
    private IBusinessImpl business;
	Scanner sc = new Scanner(System.in);
	

	private void addArticle() {
		System.out.println("saisissez le nom de l'article à ajouter");
		String name = sc.next();
		System.out.println("saisissez la marque de l'article");
		String brand = sc.next();
		System.out.println("saisissez le prix de l'article");
		double price = sc.nextDouble();
		
		
		business.save(name, brand, price);
		
	}

	private void displayAllArticles() {
		
		for (Article article : business.getAllArticles()) {
			System.out.println(article);

		} }
		
		private void displayAllCategories() {
			for (Category category : business.getAllCategories()) {
				System.out.println(category);
			}
			
		}


	public static void main(String[] args) {

		SpringApplication.run(SpringShopJpa1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Category tablet = categoryRepository.save(new Category("Tablet"));
//		Category pc = categoryRepository.save(new Category("PC"));
		// Category smartphone = categoryRepository.save(new Category("Smartphone"));
		// articleRepository.save(new Article(4, "S9", "Samsung", 250, smartphone));
//		articleRepository.save(new Article("S8", "Samsung", 250, smartphone));
//		articleRepository.save(new Article("Galaxy", "Samsung", 350, smartphone));
//		articleRepository.save(new Article("S10", "Samsung", 500, smartphone));
//		articleRepository.save(new Article("MI10", "Xiaomi", 100, smartphone));
//		articleRepository.save(new Article("GalaxyTab", "Samsung", 450, tablet));-
//		articleRepository.save(new Article("IPad", "Apple", 350, tablet));
//		articleRepository.save(new Article("R510", "Asus", 600, pc));

//		articleRepository.deleteById((long) 2);

		System.out.println("Bienvenue dans notre shop. Que souhaitez-vous faire ?");
		System.out.println("1 - Afficher tous les articles");
		System.out.println("2 - Ajouter un article");
		System.out.println("3 - Supprimer un article");
		System.out.println("4 - Modifier un article");
		System.out.println("5 - Rechercher un article");
		System.out.println("6 - afficher la liste des catégories");
		while (!sc.hasNextInt()) sc.next();
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			displayAllArticles();
			break;
		case 2:
			addArticle();
			break;
		case 6:
			displayAllCategories();
		}
	}

	

}

//	for (Article article : articleRepository.findByDescriptionAndBrand("S9", "Samsung")) {
//	 System.out.println(article);
//		}
//		for (Article article : articleRepository.findByBrandAndPriceGreaterThan("Samsung", 300)) {
//			 System.out.println(article);
//				}
//		for (Article article : articleRepository.searchArticles("sung", 200)) {
//			 System.out.println(article);
//				}
//		for (Category category : categoryRepository.findAllByOrderByNameAsc()) {
//			System.out.println(category);
//			
//		}
