package application;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JComboBox;

import db.DB;
import model.dao.impl.ClienteDaoImplementacao;
import model.dao.impl.FreteDaoImplementacao;
import model.dao.impl.FuncionarioDaoImplementacao;
import model.dao.impl.UsuarioDaoImplementacao;
import model.entities.Cargo;
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
//		Cliente cli = clienteimp.findById(999);
//		System.out.println(cli);
		
// -------------------------------testando criação do BD---------------------------------------------
		
		//DB.createDataBase();
		
//---------------------------------------- testando instanciação da classe frete ------------------
//		Status status = new Status(19,"Partiu!!!");
//		Cliente cliente = new Cliente(015,"Jose","5566-7788","jose_do_pneu@bol.com","Rua: Marechal dos pregos", null);
//		Funcionario funcionario = new Funcionario(006,"Carlos Fast Silva", "9988-7766", "carlos_capotavan@ig.com", "Rua Sumida", null, null);
//		Frete frete = new Frete(01,"Cadeira Gamer", (double) 1500, "AGSDH75HF", "Rua: Oculta", 131, cliente, funcionario, status);
//		System.out.println(frete);
//------------------------------testando insert de usuario-	OK------------------------------------------------------------------
	
//			Connection conn = DB.getConnection();
//			UsuarioDaoImplementacao usuarioImp = new UsuarioDaoImplementacao(conn);
//			
//			Usuario usu = new Usuario(30,"noe","anta");// não usar 0 a esquerda
//			
//			usuarioImp.insert(usu);
//			Usuario userr = usuarioImp.findById(30);
//			System.out.println(userr);
//----------------------------testando update de usuario ------------------------
//		
//		Connection conn = DB.getConnection();
//		UsuarioDaoImplementacao usuarioimp = new UsuarioDaoImplementacao(conn);
//		
//		Usuario user = usuarioimp.findById(13);
//		user.setSenha("kkkkk");
//		
//		usuarioimp.update(user);
//		
//		System.out.println(user);
//----------------------------------- testando find all usuario ---------------
		
//		Connection conn = DB.getConnection();
//		UsuarioDaoImplementacao usuarioimp = new UsuarioDaoImplementacao(conn);
//	System.out.println(	usuarioimp.findAll());
// ------------------------------- testando delete by id usuario -----ok-------------------
//		Connection conn = DB.getConnection();
//		UsuarioDaoImplementacao usuarioimp = new UsuarioDaoImplementacao(conn);
//		usuarioimp.deleteById(804);
		
// ------------------------------- testando delete by id cliente -ok-----------------------
//		Connection conn = DB.getConnection();
//		ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
//		clienteimp.deleteById(904);
// ------------------------- relembrando array list of object---ok------------------------------
//		ArrayList<Usuario> usuarray = new ArrayList<Usuario>();
//		Usuario usuario1 = new Usuario();
//		
//		usuario1.setIdUsuario(70);
//		usuario1.setLogin("hue");
//		usuario1.setSenha("brbr");
//		
//		Usuario usuario2 = new Usuario();
//		
//		usuario2.setIdUsuario(71);
//		usuario2.setLogin("kkkk");
//		usuario2.setSenha("nocry");
//		
//		usuarray.add(usuario1);
//		usuarray.add(usuario2);
//		
//		//System.out.println(usuarray);
//		System.out.println(usuarray.get(1));// get theobject in position
		
//------------------------------- //------------------------------testando insert de Cliente-------------------------------------------------------------------
	
//	Connection conn = DB.getConnection();
//	ClienteDaoImplementacao clienteImp = new ClienteDaoImplementacao(conn);
	
//	Cliente cli = new Cliente(12, "nome", "telefone", "email", "endereco", "login"," senha");// não usar 0 a esquerda
	
//	clienteImp.insert(cli);
	//Usuario userr = usuarioImp.findById(30);
	//System.out.println(userr);
//--------------------------------------------------------- FUNCIONARIO TESTES ----------------------------	
	
//		Connection conn = DB.getConnection();
//		FuncionarioDaoImplementacao funcionarioImp = new FuncionarioDaoImplementacao(conn);
//		System.out.println(funcionarioImp);
//	
//	//insert ok
//	
//
//Cargo car = new Cargo(12, "Gerente", 1500);
//Funcionario fun = new Funcionario(12, "abc", "abc", "aa", "bb", "kkkkkk", car);
//	
//	funcionarioImp.insert(fun);
		
	//findall ok
	
//	System.out.println( funcionarioImp.findAll());
	
	// findid ok
	
//	System.out.println(funcionarioImp.findById(11));
	
	// delid ok
	
//		funcionarioImp.deleteById(11);
	// attidp ok
		
	//	funcionarioImp.update(fun);
		
//----------------------------------------FRETE TESTES -------------------------------------------------------------------------
		Connection conn = DB.getConnection();
		FreteDaoImplementacao freteImp = new FreteDaoImplementacao(conn);
		System.out.println(freteImp);
		
//		ClienteDaoImplementacao clienteImp = new ClienteDaoImplementacao(conn);
//		
//		Cliente cli = clienteImp.findById(777);
//		System.out.println(cli);
//		
//		FuncionarioDaoImplementacao funcionarioImp = new FuncionarioDaoImplementacao(conn);
//		
//		Funcionario fun = funcionarioImp.findById(4321);
//		System.out.println(fun);
//		
//		Status status = new Status(31,"Rota"); // dps implementar o metodo findById no status e usar ele
//		System.out.println("valor do status"+status);
//		//status =null;
//		//System.out.println("valor do status apos setar objto null"+status);
//		
//		Frete frete = new Frete(9902, "Notebook",(double)4500, "ATK001", "Rua cambuci pg guarus", 9, cli, fun, status);
//		
//		System.out.println(frete.getCliente().getIdCliente());
//		
//		System.out.println(frete.getFuncionario().getIdFuncionario());
//		
//		System.out.println(frete.getStatus().getIdStatus());
//		
//		
//		System.out.println(frete);
//				
////insert ok program		
//		freteImp.insert(frete);
//--------------------------------------------------------------------------------------------------------------	
////del ok program		
//		freteImp.deleteById(9901);
//------------------------------------------------------------------------
////findById ok program		
		
//--		System.out.println(freteImp.findById(558));
//-----------------------------------------------------------------------------
////findAll ok program

		System.out.println(freteImp.findAll());

//-------------------------- load box TEST---------------------------------------
		
//		//JComboBox<Cliente> comboBox = new JComboBox<Cliente>();
//				JComboBox<String> comboBox = new JComboBox<String>();
//				comboBox.setBounds(46, 39, 239, 32);
//				contentPane.add(comboBox);
//				
//				Connection conn = DB.getConnection();
//				ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
//				//System.out.println(	clienteimp.findAll());
//				
//				ArrayList<Cliente> usuArray = new ArrayList<Cliente>();
//				usuArray = clienteimp.findAll();
//				ArrayList<Integer> idCli = new ArrayList<Integer>();
//				
//				for (Cliente cli : usuArray) {
//					comboBox.addItem(cli.getNome());
//					idCli.add(cli.getIdCliente());
//					
//				}
//				
//				System.out.println(comboBox.getSelectedIndex());
//			
//				
//				//System.out.println(comboBox.getSelectedItem());
//				
//				
//			
//				
//				
////				---------------------------------------------------------------
//				JComboBox<String> comboBoxFun = new JComboBox<String>();
//				comboBoxFun.setBounds(312, 39, 239, 32);
//				contentPane.add(comboBoxFun);
//				
//				Connection connFun = DB.getConnection();
//				FuncionarioDaoImplementacao funcionarioimp = new FuncionarioDaoImplementacao(connFun);
//				
//				ArrayList<Funcionario> usuArrayFun = new ArrayList<Funcionario>();
//				usuArrayFun = funcionarioimp.findAll();
//				ArrayList<Integer> idFun = new ArrayList<Integer>();
//				
//				for (Funcionario fun : usuArrayFun) {
//					comboBoxFun.addItem(fun.getNome());
//					idFun.add(fun.getIdFuncionario());
//					
//				}
//				System.out.println(idFun);
}
	}