package model.dao;

import java.util.List;

import model.entities.Frete;

public interface FreteDao {
	void insert (Frete obj);
	void update (Frete obj);
	void deleteById(Integer id);
	Frete findById (Integer id);
	List<Frete> findAll();
}
