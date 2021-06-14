package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import model.entities.Status;

public class Program {

	public static void main(String[] args) {
	//	Connection conn = DB.getConnection();
	//	DB.closeConnection();
		
//		Connection conn = null;
//		PreparedStatement st = null;
//	
//		try {
//			conn = DB.getConnection(); //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_agenda", "root", "root01");
//			st = conn.prepareStatement(
//					"INSERT INTO pfisicas"
//					+ "(cpf, nome, email)"
//					+ "VALUES"
//					+ "(?, ?, ?)",
//					Statement.RETURN_GENERATED_KEYS);
//			
//			st.setInt(1, 12333);
//			st.setString(2, "Juve");
//			st.setString(3, "juve@bol.com");
//					
//			 st.executeUpdate();
//			
//			
//			
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			
//			DB.closeStatement(st);//st.close
//			DB.closeConnection();
//		}
//	
	
	//----- listar
	
//	Connection conn = null;
//	Statement st = null;
//	ResultSet rs = null;
//	try {
//		conn = DB.getConnection();
//		st = conn.createStatement();
//		
//		rs = st.executeQuery("select * from status");
//		
//		while (rs.next()) {
//			
//			System.out.println(rs.getInt("Id_status")+ ", "+ rs.getString("Descricao"));
//			
//		}
//		
//	}
//	catch (SQLException e) {
//		e.printStackTrace();
//	}
//	finally {
//		DB.closeResultSet(rs);;
//		DB.closeStatement(st);
//		DB.closeConnection();
//	}
//
//}
		Status obj = new Status(19, "Extraviado");
		System.out.println(obj);
}}
