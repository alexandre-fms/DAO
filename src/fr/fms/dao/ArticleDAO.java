package fr.fms.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;

public class ArticleDAO implements DAO<Article>{

	@Override
	public void create(Article obj) {
		String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice, IdCategory) VALUES (?, ?, ?, ?)";
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getDescription());
			ps.setString(2, obj.getBrand());
			ps.setDouble(3, obj.getPrice());
			ps.setInt(4, obj.getIdCategory());
			if(ps.executeUpdate() == 1)System.out.println("Insertion OK");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insertion failed, vérifiez vos informations.");
		}
	}
	@Override
	public boolean update(Article obj) {
		String str = "UPDATE T_Articles SET Brand = ? WHERE IdArticle = ?";
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getBrand());
			ps.setInt(2, obj.getId());
			if(ps.executeUpdate() == 1)System.out.println("Update OK");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("update failed, vérifiez vos informations.");
		}
		return false;
	}
	@Override
	public boolean delete(Article obj) {
		String str = "DELETE FROM T_Articles WHERE IdArticle = ?";
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, obj.getId());
			if(ps.executeUpdate() == 1)System.out.println("Delete OK");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("suppression failed, vérifiez vos informations.");
		}
		return false;
	}
	@Override
	public Article read(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Article> readAll() {
		ArrayList<Article> articles = new ArrayList<Article>();
		
			String strSql = "SELECT * FROM T_Articles";
			
			try(Statement stmt = connection.createStatement()) {
				try(ResultSet resultSet = stmt.executeQuery(strSql)) {
					while(resultSet.next()) {
						int rsIdUser = resultSet.getInt(1);
						String rsDescription = resultSet.getString(2);
						String rsBrand = resultSet.getString(3);
						double rsPrice = resultSet.getDouble(4);
						int rsIdCategory = resultSet.getInt(5);
						articles.add((new Article(rsIdUser, rsDescription, rsBrand, rsPrice, rsIdCategory)));
					}				
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Impossible de récpérer les données.");
			} 
			for(Article a : articles) {
				System.out.println(a.getId() +"  -  " + a.getDescription() + "  -  " +
			a.getBrand() + "  -  " + a.getPrice());
			}
			return articles;
			
		
	}
	
	
}
