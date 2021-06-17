package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Date;

import db.DB;
import model.dao.UsuarioDao;
import model.dao.impl.ClienteDaoImplementacao;
import model.dao.impl.UsuarioDaoImplementacao;
import model.entities.Cliente;
//import model.entities.Cargo;
//import model.entities.Status;
import model.entities.Usuario;

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


//		//------------------------------------------------------
//		Status obj = new Status(19, "Extraviado");
//		System.out.println(obj);
//		
//		Cargo carg = new Cargo(24, "Gerente",5000,new Date(), null);
//		System.out.println(carg);
		
//----------------ok --------------------------------------------------------------
//	Connection conn = DB.getConnection();
//	UsuarioDaoImplementacao imp = new UsuarioDaoImplementacao(conn);
//	Usuario userr = imp.findById(6621);
//	System.out.println(userr);
// ----------------------------- teste findby id client ------------------------
		
//		Connection conn = DB.getConnection();
//		ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
//		Cliente cli = clienteimp.findById(1);
//		System.out.println(cli);
		
// -------------------------------testando criação do BD---------------------------------------------
		
		//DB.createDataBase();
}
	
	
	
	
	
	
	
	
	
	
}