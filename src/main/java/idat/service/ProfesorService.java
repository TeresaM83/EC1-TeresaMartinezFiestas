package idat.service;

import java.util.List;

import idat.model.Profesor;

public interface ProfesorService {
	void save(Profesor p);
	void actualizar(Profesor p);
	void eliminar(Integer codigo);
	Profesor buscar(Integer codigo);
	List<Profesor> listar();
}
