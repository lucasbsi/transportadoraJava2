package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	private static Connection conn = null;
	private static String url = "jdbc:mysql://localhost:3306/transportadora_br_v2?useSSL=false";
	private static String login = "root";
	private static String senha = "root01";
	
	public static Connection getConnection() {
		if (conn == null) {
			try {
				
				conn = DriverManager.getConnection(url, login, senha);
			}
			catch (SQLException e) {
				System.out.println("Erro para conectar ao DB!!");
				throw new DbException(e.getMessage());
				
			}
		}
		System.out.println("Conexão realizada ao DB!");
		return conn;
	}
	
//	public static void createDataBase() { // a ser implementado
//	
//	}
	
	public static void closeConnection(){
		if (conn != null) {
			try {
			conn.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
	}
	

	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
	}
}
