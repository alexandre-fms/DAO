package fr.fms.dao;
import java.sql.Connection;
import java.util.ArrayList;


/**
 * 
 * @author ArenasA
 *
 */
public interface DAO<T>{
	BddConnection instance = BddConnection.getInstance();
	public Connection connection = instance.getConnection();
	public void create(T obj);
	public T read(int id);
	public boolean update(T obj);
	public boolean delete(T obj);
	public ArrayList<T> readAll();
	
	
	
	
}
