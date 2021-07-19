package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.FreteDao;
import model.entities.Cliente;
import model.entities.Frete;
import model.entities.Funcionario;
import model.entities.Status;

public class FreteDaoImplementacao implements FreteDao {
	
	private Connection conn;
	//------- construtor para gerar a dependência---------
	public FreteDaoImplementacao(Connection conn) {// retornar a conexao
		this.conn = conn;
		
	}
	
	@Override
	public void insert(Frete obj) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
		
			st = conn.prepareStatement(
					"INSERT INTO `transportadora_br_v2`.`frete`"
					+"(`Id_frete`, `Descricao`, `Valor`, `Nfe`, `Endereco`, `Numero`, `Cliente_Id_cliente`, `Funcionario_Id_funcionario`, `Status_Id_status`)"
					+"VALUES"
					+"(?, ?, ?, ?, ?, ?, ?, ?, ?)"
					, Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getIdFrete());
			st.setString(2, obj.getDescricao());
			st.setDouble(3, obj.getValor());
			st.setString(4, obj.getNfe());
			st.setString(5, obj.getEndereco());
			st.setInt(6, obj.getNumero());
			st.setInt(7, obj.getCliente().getIdCliente());
			st.setInt(8, obj.getFuncionario().getIdFuncionario());
			//---------------tratamento caso o objeto não possua status definido -------------------------
//			//System.out.println("o valor é "+obj.getStatus().getIdStatus());
//			if ((obj.getStatus().getIdStatus() == null) || (obj.getStatus() == null)) {
//				
//				st.setInt(9, 0);
//			}else {
//				st.setInt(9, obj.getStatus().getIdStatus());
//			}
			st.setInt(9, obj.getStatus().getIdStatus());
			int rowsAffected = st.executeUpdate();
			
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					System.out.println(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Deu erro pra inserir mano kkkk -- insert frete - nenhuma linha inserida");
			}
		}
		catch(SQLException e) {
			System.out.println("Deu erro pra inserir aqui tbm mano kkkk - catch do try");
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Frete obj) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateStatus(int codigoFrete, int codigoStatus) {
		PreparedStatement st = null;
		try {
		
			st = conn.prepareStatement(
					
					"UPDATE `transportadora_br_v2`.`frete`\r\n" + 
					"SET\r\n" + 
					"`Status_Id_status` = ?\r\n" + 
					 
					"WHERE `Id_frete` = ?");
			
		
			st.setInt(1, codigoStatus);
			st.setInt(2, codigoFrete);
			
			
			int rowsAffected = st.executeUpdate();
			System.out.println("O rowsAffected foi de:"+ rowsAffected);
		
		}
		catch(SQLException e) {
			System.out.println("Deu erro pra inserir aqui tbm mano kkkk");
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
		
			st = conn.prepareStatement(
					
					"DELETE FROM `transportadora_br_v2`.`frete`"
					+"WHERE `Id_frete` = ?;");
			
			st.setInt(1, id);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("O rowsAffected DELETADO frete foi de:"+ rowsAffected);
		
		}
		catch(SQLException e) {
			System.out.println("Deu erro pra inserir aqui tbm mano kkkk");
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Frete findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT f.*,\r\n" + 
					"					        fu.Id_funcionario,			\r\n" + 
					"					        fu.Nome as fuNome, \r\n" + 
					"					        fu.Telefone as fuTelefone, \r\n" + 
					"					        fu.Email as fuEmail, \r\n" + 
					"					        fu.Login as fuLogin, \r\n" + 
					"					        fu.Senha as fuSenha, \r\n" + 
					"					        fu.Cargo_Id_cargo, \r\n" + 
					"					        Id_cliente, \r\n" + 
					"					        c.Nome as cliNome, \r\n" + 
					"					        c.Telefone as cliTelefone, \r\n" + 
					"					        c.Email as cliEmail, \r\n" + 
					"					        c.Login as cliLogin, \r\n" + 
					"					        c.Senha as cliSenha,\r\n" + 
					"					        s.Id_status ,          \r\n" + 
					"					        s.Descricao as staDescricao\r\n" + 
					"					FROM transportadora_br_v2.frete f \r\n" + 
					"					INNER JOIN transportadora_br_v2.funcionario fu ON \r\n" + 
					"					f.Funcionario_Id_funcionario = fu.Id_funcionario \r\n" + 
					"					INNER JOIN transportadora_br_v2.cliente c ON \r\n" + 
					"					c.Id_cliente = f.Cliente_Id_cliente\r\n" + 
					"					INNER JOIN transportadora_br_v2.status s ON\r\n" + 
					"					s.Id_status = f.Status_Id_status\r\n" + 
					"					WHERE f.Id_frete = ?");
			st.setInt (1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Frete obj = new Frete();
				
				obj.setIdFrete(rs.getInt("Id_frete"));
				obj.setDescricao(rs.getString("Descricao"));
				obj.setValor(rs.getDouble("Valor"));
				obj.setNfe(rs.getString("Nfe"));
				obj.setEndereco(rs.getString("Endereco"));
				obj.setNumero(rs.getInt("Numero"));
				
				Funcionario fun = new Funcionario();
				fun.setIdFuncionario(rs.getInt("Id_funcionario"));
				fun.setNome(rs.getString("fuNome"));
				fun.setTelefone(rs.getString("fuTelefone"));
				fun.setEmail(rs.getString("fuEmail"));
				fun.setLogin(rs.getString("fuLogin"));
				fun.setSenha(rs.getString("fuSenha"));
				
				obj.setFuncionario(fun);	
				
				Cliente cli = new Cliente();
				cli.setIdCliente(rs.getInt("Id_cliente"));
				cli.setNome(rs.getString("cliNome"));
				cli.setTelefone(rs.getString("cliTelefone"));
				cli.setEmail(rs.getString("cliEmail"));
				cli.setLogin(rs.getString("cliLogin"));
				cli.setSenha(rs.getString("cliSenha"));
				
				obj.setCliente(cli);
				
				Status status = new Status();
				status.setIdStatus(rs.getInt("Id_status"));
				status.setDescricao(rs.getString("staDescricao"));
				
				obj.setStatus(status);
				
				return obj;
				
			}
			System.out.println("Zebrou jão");
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
//		return null;
	}

	@Override
	public ArrayList<Frete> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
		st = conn.prepareStatement(
				"SELECT f.*,\r\n" + 
				"					        fu.Id_funcionario,			\r\n" + 
				"					        fu.Nome as fuNome, \r\n" + 
				"					        fu.Telefone as fuTelefone, \r\n" + 
				"					        fu.Email as fuEmail, \r\n" + 
				"					        fu.Login as fuLogin, \r\n" + 
				"					        fu.Senha as fuSenha, \r\n" + 
				"					        fu.Cargo_Id_cargo, \r\n" + 
				"					        Id_cliente, \r\n" + 
				"					        c.Nome as cliNome, \r\n" + 
				"					        c.Telefone as cliTelefone, \r\n" + 
				"					        c.Email as cliEmail, \r\n" + 
				"					        c.Login as cliLogin, \r\n" + 
				"					        c.Senha as cliSenha,\r\n" + 
				"					        s.Id_status ,          \r\n" + 
				"					        s.Descricao as staDescricao\r\n" + 
				"					FROM transportadora_br_v2.frete f \r\n" + 
				"					INNER JOIN transportadora_br_v2.funcionario fu ON \r\n" + 
				"					f.Funcionario_Id_funcionario = fu.Id_funcionario \r\n" + 
				"					INNER JOIN transportadora_br_v2.cliente c ON \r\n" + 
				"					c.Id_cliente = f.Cliente_Id_cliente\r\n" + 
				"					INNER JOIN transportadora_br_v2.status s ON\r\n" + 
				"					s.Id_status = f.Status_Id_status\r\n" + 
				"					");
		
		rs = st.executeQuery();
		
		ArrayList<Frete> freteArray = new ArrayList<Frete>();
		
		while(rs.next()) {
			Frete obj = new Frete();
			
			obj.setIdFrete(rs.getInt("Id_frete"));
			obj.setDescricao(rs.getString("Descricao"));
			obj.setValor(rs.getDouble("Valor"));
			obj.setNfe(rs.getString("Nfe"));
			obj.setEndereco(rs.getString("Endereco"));
			obj.setNumero(rs.getInt("Numero"));
			
			Funcionario fun = new Funcionario();
			fun.setIdFuncionario(rs.getInt("Id_funcionario"));
			fun.setNome(rs.getString("fuNome"));
			fun.setTelefone(rs.getString("fuTelefone"));
			fun.setEmail(rs.getString("fuEmail"));
			fun.setLogin(rs.getString("fuLogin"));
			fun.setSenha(rs.getString("fuSenha"));
			
			obj.setFuncionario(fun);	
			
			Cliente cli = new Cliente();
			cli.setIdCliente(rs.getInt("Id_cliente"));
			cli.setNome(rs.getString("cliNome"));
			cli.setTelefone(rs.getString("cliTelefone"));
			cli.setEmail(rs.getString("cliEmail"));
			cli.setLogin(rs.getString("cliLogin"));
			cli.setSenha(rs.getString("cliSenha"));
			
			obj.setCliente(cli);
			
			Status status = new Status();
			status.setIdStatus(rs.getInt("Id_status"));
			status.setDescricao(rs.getString("staDescricao"));
			
			obj.setStatus(status);
			
			freteArray.add(obj);
			
		}
		//System.out.println("Zebrou jão");
		return freteArray;
		
	}
	catch(SQLException e) {
		throw new DbException(e.getMessage());
	}
	finally {
		DB.closeStatement(st);
		DB.closeResultSet(rs);
	}
//	return null;
		
	}

}
