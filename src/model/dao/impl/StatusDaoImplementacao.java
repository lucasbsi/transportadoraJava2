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
import model.dao.StatusDao;
import model.entities.Cliente;
import model.entities.Status;
import model.entities.Usuario;

public class StatusDaoImplementacao implements StatusDao {
	
	private Connection conn;
	//------- construtor para gerar a dependência---------
	public StatusDaoImplementacao(Connection conn) {// retornar a conexao
		this.conn = conn;
		
	}
	@Override
	public void insert(Status obj) {
		PreparedStatement st = null;
		try {
		
			st = conn.prepareStatement(
					"INSERT INTO `transportadora_br_v2`.`status`"
					+"(`Id_status`,`Descricao`)"
					+"VALUES"
					+"(?, ?)"
					, Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getIdStatus());
			st.setString(2, obj.getDescricao());
			
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
				throw new DbException("Erro: Nenhuma linha adicionada");
			}
		}
		catch(SQLException e) {
			System.out.println("Erro ao tentar inserir o Status no DB");
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Status obj) {
		PreparedStatement st = null;
		try {
		
			st = conn.prepareStatement(
					
					"UPDATE `transportadora_br_v2`.`status`\r\n" + 
					"SET\r\n" + 
					"`Id_status` = ?,\r\n" + 
					"`Descricao` = ?\r\n" + 
					"WHERE `Id_status` = ?");
			
		
			st.setInt(1, obj.getIdStatus());
			st.setString(2, obj.getDescricao());
			st.setInt(3, obj.getIdStatus());
			
			
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
					
					"DELETE FROM `transportadora_br_v2`.`status`"
					+"WHERE `Id_status` = ?;");
			
			st.setInt(1, id);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("A quantidade de Status removidos:"+ rowsAffected);
		
		}
		catch(SQLException e) {
			System.out.println("Erro para deletar Status do BD.");
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
		
	}

	@Override
	public Status findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM status WHERE Id_status =?");
			st.setInt (1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Status obj = new Status();
				
				
				obj.setIdStatus(	rs.getInt("Id_status"));
				obj.setDescricao(rs.getString("Descricao"));
				
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
	public ArrayList<Status> findAll() {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM status ORDER BY Id_status");
			rs = st.executeQuery();
			ArrayList<Status> statArray = new ArrayList<Status>();
		//	int i =0;
			
			while(rs.next()) {
				Status stat = new Status();
				
				stat.setIdStatus(	rs.getInt("Id_status"));
				stat.setDescricao(rs.getString("Descricao"));
				
				statArray.add(stat);	
					
				}
			//System.out.println(usuArray);
			return statArray;
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
