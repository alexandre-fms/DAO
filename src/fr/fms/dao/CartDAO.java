package fr.fms.dao;

import java.util.ArrayList;

import fr.fms.entities.Article;
import fr.fms.entities.Cart;
import fr.fms.entities.User;

public interface CartDAO {
	/**
	 * ajoute un article dans le panier
	 * @param article l'article à ajouter
	 * @param user l'utilisateuer associé au panier
	 * @return true si l'ajout est un succès
	 */
	public boolean addToCart(Article article, User user);
	/**
	 * retire un article du panier
	 * @param cart	le panier duquel sera retiré l'article
	 * @param article	l'article à retirer
	 * @param user	l'utilisateur associé au panier
	 * @return	true si le retrait a été effectué
	 */
	public boolean removeFromCart(Cart cart,Article article, User user);
	/**
	 * supprime le panier
	 * @param cart	le panier à supprimer
	 * @param user l'utilisateur correspondant au panier
	 * @return true si la suppression a été effectuée
	 */
	public boolean clearCart(Cart cart, User user);
	/**
	 * convertit le panier en commande
	 * @param cart le contenu du panier à ajouter en commande
	 * @param user	l'utilisateur associé à la commande
	 * @return true si la convertion a bien eu lieu
	 */
	public boolean newOrder(Cart cart, User user);
}
