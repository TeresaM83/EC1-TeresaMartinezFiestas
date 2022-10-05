package idat.service;

import java.util.List;

import idat.model.Curso;

public interface CursoService {
	void save(Curso c);
	void actualizar(Curso c);
	void eliminar(Integer codigo);
	Curso buscar(Integer codigo);
	List<Curso> listar();
}
