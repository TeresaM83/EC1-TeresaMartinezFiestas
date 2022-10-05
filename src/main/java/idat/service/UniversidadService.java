package idat.service;

import java.util.List;

import idat.model.Universidad;

public interface UniversidadService {
	void save(Universidad u);
	void actualizar(Universidad u);
	void eliminar(Integer codigo);
	Universidad buscar(Integer codigo);
	List<Universidad> listar();
}
