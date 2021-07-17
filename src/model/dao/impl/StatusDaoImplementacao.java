package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Status obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
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
