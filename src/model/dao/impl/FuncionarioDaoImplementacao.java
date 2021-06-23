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
import model.dao.FuncionarioDao;
import model.entities.Cliente;
import model.entities.Funcionario;

public class FuncionarioDaoImplementacao implements FuncionarioDao {
	
	private Connection conn;
	//------- construtor para gerar a dependência---------
	public FuncionarioDaoImplementacao(Connection conn) {// retornar a conexao
		this.conn = conn;
		
	}

	@Override
	public void insert(Funcionario obj) {// ok
		PreparedStatement st = null;
		//System.out.println(obj.getCargo().getIdCargo());
		try {
		
			st = conn.prepareStatement(
					"INSERT INTO `transportadora_br_v2`.`funcionario`"
					+"(`Id_funcionario`,`Nome`,`Telefone`,`Email`,`Login`,`Senha`)"
					+"VALUES"
					+"(?, ?, ?, ?, ?, ?)"
					, Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getIdFuncionario());
			st.setString(2, obj.getNome());
			st.setString(3, obj.getTelefone());
			st.setString(4, obj.getEmail());
			st.setString(5, obj.getLogin());
			st.setString(6, obj.getSenha());
			//st.setInt(7, obj.getCargo().getIdCargo());
			
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
	public void update(Funcionario obj) {
		PreparedStatement st = null;
		try {
		
			st = conn.prepareStatement(
					
					"UPDATE `transportadora_br_v2`.`funcionario`"
					+"SET"
					+"`Senha` = ?"
					+"WHERE `Id_funcionario` = ?;");
			
			st.setInt(2, obj.getIdFuncionario());
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
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
		
			st = conn.prepareStatement(
					
					"DELETE FROM `transportadora_br_v2`.`funcionario`"
					+"WHERE `Id_funcionario` = ?;");
			
			st.setInt(1, id);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("O rowsAffected DELETADO funcionario foi de:"+ rowsAffected);
		
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
	public Funcionario findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM funcionario WHERE Id_funcionario =?");
			st.setInt (1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Funcionario obj = new Funcionario();
				
				
				obj.setIdFuncionario(	rs.getInt("Id_funcionario"));
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
	public ArrayList<Funcionario> findAll() {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM funcionario ORDER BY Id_funcionario");
			rs = st.executeQuery();
			ArrayList<Funcionario> usuArray = new ArrayList<Funcionario>();
		//	int i =0;
			
			while(rs.next()) {
				Funcionario fun = new Funcionario();
				
				fun.setIdFuncionario(	rs.getInt("Id_funcionario"));
				fun.setNome(rs.getString("Nome"));
				fun.setTelefone(rs.getString("Telefone"));
				fun.setEmail(rs.getString("Email"));
				fun.setLogin(rs.getString("Login"));
				fun.setSenha(rs.getString("Senha"));
				usuArray.add(fun);	
					
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
