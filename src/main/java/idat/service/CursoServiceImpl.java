package idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.model.Curso;
import idat.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository repository;
	
	@Override
	public void save(Curso c) {
		repository.save(c);
	}

	@Override
	public void actualizar(Curso c) {
		repository.saveAndFlush(c);
	}

	@Override
	public void eliminar(Integer codigo) {
		repository.deleteById(codigo);
	}

	@Override
	public Curso buscar(Integer codigo) {
		return repository.findById(codigo).orElse(null);
	}

	@Override
	public List<Curso> listar() {
		return repository.findAll();
	}

}
