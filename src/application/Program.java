package application;

import java.sql.Connection;

import db.DB;
import model.dao.impl.UsuarioDaoImplementacao;
import model.entities.Cliente;
import model.entities.Frete;
import model.entities.Funcionario;
import model.entities.Status;
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
//		
//		Connection conn = DB.getConnection();
//		ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
//		Cliente cli = clienteimp.findById(1);
//		System.out.println(cli);
		
// -------------------------------testando criação do BD---------------------------------------------
		
		//DB.createDataBase();
		
//---------------------------------------- testando instanciação da classe frete ------------------
//		Status status = new Status(19,"Partiu!!!");
//		Cliente cliente = new Cliente(015,"Jose","5566-7788","jose_do_pneu@bol.com","Rua: Marechal dos pregos", null);
//		Funcionario funcionario = new Funcionario(006,"Carlos Fast Silva", "9988-7766", "carlos_capotavan@ig.com", "Rua Sumida", null, null);
//		Frete frete = new Frete(01,"Cadeira Gamer", (double) 1500, "AGSDH75HF", "Rua: Oculta", 131, cliente, funcionario, status);
//		System.out.println(frete);
//------------------------------testando inserção de usuario-------------------------------------------------------------------
	
			Connection conn = DB.getConnection();
			UsuarioDaoImplementacao usuarioImp = new UsuarioDaoImplementacao(conn);
			Usuario usu = new Usuario(017,"ajesus","moquitolove");
			usuarioImp.insert(usu);
			Usuario userr = usuarioImp.findById(017);
			System.out.println(userr);
			
			
			
	}
	
	
	
	
	
	
	
	
	
	
}