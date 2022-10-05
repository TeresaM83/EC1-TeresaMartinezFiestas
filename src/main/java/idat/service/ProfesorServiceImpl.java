package idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.model.Profesor;
import idat.repository.ProfesorRepository;
@Service

public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public void save(Profesor p) {
		repository.save(p);
	}

	@Override
	public void actualizar(Profesor p) {
		repository.saveAndFlush(p);
	}

	@Override
	public void eliminar(Integer codigo) {
		repository.deleteById(codigo);
	}

	@Override
	public Profesor buscar(Integer codigo) {
		return repository.findById(codigo).orElse(null);
	}

	@Override
	public List<Profesor> listar() {
		return repository.findAll();
	}

}
