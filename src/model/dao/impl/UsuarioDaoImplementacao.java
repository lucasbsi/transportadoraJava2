package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.UsuarioDao;
import model.entities.Usuario;

public class UsuarioDaoImplementacao implements UsuarioDao {

//------- construtor para gerar a dependência---------
	private Connection conn;
	
	public UsuarioDaoImplementacao(Connection conn) {
		this.conn = conn;
		
	}
//------------------------------
	@Override
	public void insert(Usuario obj) {
		PreparedStatement st = null;
		try {
		
			st = conn.prepareStatement(
					
					"INSERT INTO `transportadora_br`.`usuario`" 
					+ "(`Id_usuario`,`Login`,`Senha`) "
					+ "values "
					+ "(?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getIdUsuario());
			st.setString(2, obj.getLogin());
			st.setString(3, obj.getSenha());
			
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
	public void update(Usuario obj) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
		
			st = conn.prepareStatement(
					
					"UPDATE `transportadora_br`.`usuario`"
					+"SET"
					+"`Senha` = ?"
					+"WHERE `Id_usuario` = ?;");
			
			st.setInt(2, obj.getIdUsuario());
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM usuario WHERE Id_usuario =?");
			st.setInt (1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Usuario obj = new Usuario();
				obj.setIdUsuario(rs.getInt("Id_usuario"));
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
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
