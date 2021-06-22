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
import model.dao.ClienteDao;
import model.entities.Cliente;
import model.entities.Usuario;

public class ClienteDaoImplementacao implements ClienteDao {
	
	
	private Connection conn;
	//------- construtor para gerar a dependência---------
	public ClienteDaoImplementacao(Connection conn) {// retornar a conexao
		this.conn = conn;
		
	}
	@Override
	public void insert(Cliente obj) { // teste interface OK
		PreparedStatement st = null;
		try {
		
			st = conn.prepareStatement(
					"INSERT INTO `transportadora_br_v2`.`cliente`"
					+"(`Id_cliente`,`Nome`,`Telefone`,`Email`,`Login`,`Senha`)"
					+"VALUES"
					+"(?, ?, ?, ?, ?, ?)"
					, Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getIdCliente());
			st.setString(2, obj.getNome());
			st.setString(3, obj.getTelefone());
			st.setString(4, obj.getEmail());
			st.setString(5, obj.getLogin());
			st.setString(6, obj.getSenha());
			
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
				throw new DbException("Deu erro pra inserir mano kkkk");
			}
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
	public void update(Cliente obj) {// teste de interface ok
		PreparedStatement st = null;
		try {
		
			st = conn.prepareStatement(
					
					"UPDATE `transportadora_br_v2`.`cliente`"
					+"SET"
					+"`Senha` = ?"
					+"WHERE `Id_cliente` = ?;");
			
			st.setInt(2, obj.getIdCliente());
			//st.setString(2, obj.getLogin());
			st.setString(1, obj.getSenha());
			
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
	public void deleteById(Integer id) {// teste de interface OK
		PreparedStatement st = null;
		try {
		
			st = conn.prepareStatement(
					
					"DELETE FROM `transportadora_br_v2`.`cliente`"
					+"WHERE `Id_cliente` = ?;");
			
			st.setInt(1, id);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("O rowsAffected DELETADO cliente foi de:"+ rowsAffected);
		
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
	public Cliente findById(Integer id) { // teste de interface OK
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM cliente WHERE Id_Cliente =?");
			st.setInt (1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Cliente obj = new Cliente();
				
				
				obj.setIdCliente(	rs.getInt("Id_cliente"));
				obj.setNome(rs.getString("Nome"));
				obj.setTelefone(rs.getString("Telefone"));
				obj.setEmail(rs.getString("Email"));
				obj.setLogin(rs.getString("Login"));
				obj.setSenha(rs.getString("Senha"));
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
		
	}

	@Override
	public ArrayList<Cliente> findAll() { //teste de interface half ok está retornando o a. objeto
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM cliente ORDER BY Id_cliente");
			rs = st.executeQuery();
			ArrayList<Cliente> usuArray = new ArrayList<Cliente>();
		//	int i =0;
			
			while(rs.next()) {
				Cliente cli = new Cliente();
				
				cli.setIdCliente(	rs.getInt("Id_cliente"));
				cli.setNome(rs.getString("Nome"));
				cli.setTelefone(rs.getString("Telefone"));
				cli.setEmail(rs.getString("Email"));
				cli.setLogin(rs.getString("Login"));
				cli.setSenha(rs.getString("Senha"));
				usuArray.add(cli);	
					
				}
			//System.out.println(usuArray);
			return usuArray;
			}
//			System.out.println("Zebrou jão");
//			return null;
		
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}
	
	

}
