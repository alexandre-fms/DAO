package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.User;

public class UserDAO implements DAO<User>{

	@Override
	public void create(User obj) {
		String str = "INSERT INTO T_Users (Login, Password) VALUES (?, ?)";
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());
			if(ps.executeUpdate() == 1)System.out.println("Insertion OK");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insertion failed, vérifiez vos informations.");
		}
	}

	@Override
	public User read(int id) {
		return null;
	}

	@Override
	public boolean update(User obj) {
		String str = "UPDATE T_Users SET Login = ? Password = ? WHERE IdArticle = ?";
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, obj.getIdUser());
			ps.setString(2, obj.getLogin());
			ps.setString(2, obj.getPassword());
			if(ps.executeUpdate() == 1)System.out.println("Update OK");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("update failed, vérifiez vos informations.");
		}
		return false;
	}

	@Override
	public boolean delete(User obj) {
		String str = "DELETE FROM T_Users WHERE IdArticle = ?";
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, obj.getIdUser());
			if(ps.executeUpdate() == 1)System.out.println("Delete OK");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("suppression failed, vérifiez vos informations.");
		}
		return false;
	}

	@Override
	public ArrayList<User> readAll() {
		ArrayList<User> users = new ArrayList<User>();

		String strSql = "SELECT * FROM T_Users";

		try(Statement stmt = connection.createStatement()) {
			try(ResultSet resultSet = stmt.executeQuery(strSql)) {
				while(resultSet.next()) {
					int rsIdUser = resultSet.getInt(1);
					String rsLogin = resultSet.getString(2);
					String rsPassword = resultSet.getString(3);
					users.add((new User(rsIdUser, rsLogin, rsPassword)));
				}				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Impossible de récpérer les données.");
		} 
		for(User u : users) {
			System.out.println(u.getIdUser() +"  -  " + u.getLogin() + "  -  " +
					u.getPassword());
		}
		return users;
	}

	/**
	 * Vérifie si les informations saisies par l'utilisateur correspondent à un utilisateur existant en bdd
	 * @param user les infos User renseignées par l'utilisateur
	 * @return true si l'utilisateur existe en bdd
	 */
	public boolean authUser(User user) {
		String sql = "SELECT Login, Password FROM T_Users WHERE Login = \"" + user.getLogin() + "\" AND Password = \""+ user.getPassword()+"\";";

		try(Statement stmt = connection.createStatement()) {
			try(ResultSet resultSet = stmt.executeQuery(sql)) {
				while(resultSet.next()) {
					if(user.getLogin().equals(resultSet.getString(1)) && user.getPassword().equals(resultSet.getString(2))) {
						System.out.println("Utilisateur reconnu.");
					}
					return true;
				}
								
			}
		} catch (SQLException e1) {
			System.out.println("pas de connexion");
			e1.printStackTrace();
		}
		return false;
	}

}
