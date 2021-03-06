package fr.fms;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringShopJpa1Application implements CommandLineRunner {

	@Autowired
	private IBusinessImpl business;
	Scanner sc = new Scanner(System.in);
	int menu = 1;

	private void addArticle() {
		System.out.println("Saisissez le nom de l'article à ajouter");
		String name = sc.next();
		System.out.println("Saisissez la marque de l'article à ajouter");
		String brand = sc.next();
		System.out.println("Saisissez le prix de l'article à ajouter");
		double price = sc.nextDouble();
		System.out.println("Saisissez l'id de la catégorie de l'article à ajouter");
		displayAllCategories();
		long idCat = sc.nextLong();

		business.save(name, brand, price, idCat);

	}

	private void deleteArticle() {
		System.out.println("Saisissez l'id de l'article à supprimer");
		displayAllArticles();
		long id = sc.nextLong();
		business.deleteArticle((long) id);
	}

	private void displayAllArticles() {

		for (Article article : business.getAllArticles()) {
			System.out.println(article);

		}
	}

	private void modifyArticle() {
		System.out.println("Saisissez l'id de l'article que vous souhaitez modifier :");
		displayAllArticles();
		long id = sc.nextInt();
		System.out.println("Saisissez le nom de l'article à modifier");
		String name = sc.next();
		System.out.println("Saisissez la marque de l'article à modifier");
		String brand = sc.next();
		System.out.println("Saisissez le prix de l'article à modifier");
		double price = sc.nextDouble();
		System.out.println("Saisissez l'id de la catégorie de l'article à modifier");
		displayAllCategories();
		long idCat = sc.nextLong();

		business.modifyArticle(id, name, brand, price, idCat);

	}

	private void readOneArticle() {
		System.out.println("Quel article voulez-vous consulter ?");
		String description = sc.next();

		System.out.println(business.readOneArticle(description));
	}

	private void displayAllCategories() {
		for (Category category : business.getAllCategories()) {
			System.out.println(category);
		}

	}

	private void addCategory() {
		System.out.println("Veuillez saisir le nom de la nouvelle catégorie");
		String name = sc.next();
		business.saveCategory(name);
	}

	private void modifyCategory() {
		System.out.println("Saisissez l'id de la catégorie que vous souhaitez modifier :");
		displayAllCategories();
		long id = sc.nextInt();
		System.out.println("Saisissez le nom de la catégorie à modifier");
		String name = sc.next();
		business.modifyCategory(id, name);

	}

	public static void main(String[] args) {

		SpringApplication.run(SpringShopJpa1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Category tablet = business.saveCategory("Tablet");
//		Category pc = business.saveCategory("PC");
//		Category smartphone = business.saveCategory("Smartphone");
//	    business.save("S9", "Samsung", 250, 3);
//	    business.save("S8", "Samsung", 250, 3);
//		business.save("Galaxy", "Samsung", 350, 3);
//		business.save("S10", "Samsung", 500, 3);
//		business.save("MI10", "Xiaomi", 100, 3);
//		business.save("GalaxyTab", "Samsung", 450, 1);
//		business.save("IPad", "Apple", 350, 1);
//    	business.save("R510", "Asus", 600, 2);

//		articleRepository.deleteById((long) 2);

		System.out.println();
		System.out.println("Bienvenue dans notre shop. Que souhaitez-vous faire ?");
		System.out.println();

		while (menu == 1) {

			System.out.println();
			System.out.println("Que souhaitez-vous faire ?");
			System.out.println();
			System.out.println("1 - Afficher tous les articles");
			System.out.println("2 - Ajouter un article");
			System.out.println("3 - Supprimer un article");
			System.out.println("4 - Modifier un article");
			System.out.println("5 - Rechercher un article");
			System.out.println("6 - Afficher la liste des catégories");
			System.out.println("7 - Ajouter une catégorie");
			System.out.println("8 - Modifier une catégorie");
			System.out.println("9 - Supprimer une catégorie");
			System.out.println("0 - Quitter");

			while (!sc.hasNextInt())
				sc.next();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				displayAllArticles();
				break;
			case 2:
				addArticle();
				break;
			case 3:
				deleteArticle();
				break;
			case 4:
				modifyArticle();
				break;
			case 5:
				readOneArticle();
				break;
			case 6:
				displayAllCategories();
				break;
			case 7:
				addCategory();
				break;
			case 8:
				modifyCategory();
				break;
			case 9:
				deleteCategory();

			case 0:
				exit();
				break;
			default:
				System.out.println("mauvaise saisie");
			}
		}
	}

	private void deleteCategory() {
		// TODO Auto-generated method stub

	}

	private void exit() {
		System.out.println();
		System.out.println("Aurevoir");
		menu = 0;

	}
}