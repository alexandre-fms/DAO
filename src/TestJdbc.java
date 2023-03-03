import fr.fms.dao.ArticleDAO;
import fr.fms.dao.UserDAO;

import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.entities.*;

public class TestJdbc {
	//TODO voir en bas pour la réponse exercice 12

	public static void main(String[] args) throws Exception {
		
		String login = null, mdp = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("saisissez votre login.");
			if(scan.hasNext()) {
				login = scan.next();
			}
			System.out.println("mot de passe.");
			if(scan.hasNext()) {
				mdp = scan.next();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			User user = new User(login, mdp);
			UserDAO userDAO = new UserDAO();
			boolean userOk = userDAO.authUser(user);
			//System.out.println(userOk);
			if(userOk == true) {
				System.out.println("Bienvenue, vous avez désormais accès à la liste des articles.\n");
				
				ArticleDAO articleDAO = new ArticleDAO();
				articleDAO.readAll();
				System.out.println();
				userDAO.readAll();
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		scan.close();
	}
	/**
	 * Exercice 12: Enfin, d’après vous, quelles seraient les méthodes d’une interface
	 *	représentant la couche métier de notre appli de E commerce ici consistant à choisir dans
	 *	une liste d articles ceux que je souhaite ajouter à mon panier, supprimer, afficher
	 *
	 * il faudrait créer une classe Cart ainsi qu'une classe Order
	 * par contre pour afficher l'article depuis un panier on réutilise la méthode read() de la classe ArticleDAO
	 *
	 * public boolean addToCart(Article article, User user); 		//ajouter un paramètre int si on prend en compte le nombre d'articles
	 * public boolean removeFromCart(Cart cart,Article article, User user);	//on a besoin de savoir quel Cart, quel Article de tel User
	 * public boolean clearCart(Cart cart, User user);	//
	 * public boolean newOrder(Cart cart, User user);
	 *
	 */
	
}
