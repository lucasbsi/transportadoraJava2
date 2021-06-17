package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuario obj) {
		// TODO Auto-generated method stub
		
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
