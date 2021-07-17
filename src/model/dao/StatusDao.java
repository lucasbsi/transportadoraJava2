package model.dao;

import java.util.List;

import model.entities.Status;
import model.entities.Usuario;

public interface StatusDao {
	void insert (Status obj);
	void update (Status obj);
	void deleteById(Integer id);
	Status findById (Integer id);
	List<Status> findAll();

}
