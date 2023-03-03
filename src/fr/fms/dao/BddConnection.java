package fr.fms.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BddConnection {
	private static BddConnection bddConnection = null;
	/**
	 * création du singleton
	 * @return
	 */
	public static BddConnection getInstance() {
		if (bddConnection == null) {
			bddConnection = new BddConnection();
        	//System.out.println("c'est créé");
        }else {
        	System.out.println("Une seul connexion à la fois svp.");
        }
        	
  
        return bddConnection;
	}
	
	
	public static Properties readPropertiesFile(String fileName){
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      }
	      return prop;
	   }

	public Connection getConnection() {
		Properties prop = null;
		
		try {
			prop = readPropertiesFile("src/CreateConfigFile");
			Connection connection = DriverManager.getConnection(prop.getProperty("db.url"),
					prop.getProperty("db.login"),
					prop.getProperty("db.password"));
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problème de connexion avec la base de données, vérifiez l'existance de celle-ci ou les informations de connexion.");
		}

		return null;
	}
}
