package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ClienteDao;
import model.entities.Cliente;
import model.entities.Usuario;

public class ClienteDaoImplementacao implements ClienteDao {
	
	
	private Connection conn;
	
	public ClienteDaoImplementacao(Connection conn) {// retornar a conexao
		this.conn = conn;
		
	}
	@Override
	public void insert(Cliente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Cliente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente findById(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT * FROM cliente c INNER JOIN usuario u ON c.Usuario_Id_usuario = u.Id_usuario WHERE Id_cliente = ?");
			st.setInt (1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				
				Cliente obj = new Cliente();
				obj.setIdCliente(rs.getInt("Id_cliente"));
				obj.setNome(rs.getString("Nome"));
				obj.setTelefone(rs.getString("Telefone"));
				obj.setEmail(rs.getString("Email"));
				
				Usuario usu = new Usuario();
				usu.setIdUsuario(rs.getInt("Usuario_Id_usuario"));
				usu.setLogin(rs.getString("Login"));
				usu.setSenha(rs.getString("Senha"));
				
				obj.setUsuario(usu);
				
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
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
