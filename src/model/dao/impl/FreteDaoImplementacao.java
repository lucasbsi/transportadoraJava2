package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.FreteDao;
import model.entities.Frete;

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

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Frete findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Frete> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
