package idat.service;

import java.util.List;

import idat.model.MallaCurricular;

public interface MallaCurricularService {
	void save(MallaCurricular m);
	void actualizar(MallaCurricular m);
	void eliminar(Integer codigo);
	MallaCurricular buscar(Integer codigo);
	List<MallaCurricular> listar();
}
