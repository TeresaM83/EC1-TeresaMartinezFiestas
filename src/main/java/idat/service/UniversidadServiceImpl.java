package idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.model.Universidad;
import idat.repository.UniversidadRepository;
@Service

public class UniversidadServiceImpl implements UniversidadService {
	
	@Autowired
	private UniversidadRepository repository;
	
	@Override
	public void save(Universidad u) {
		repository.save(u);
	}

	@Override
	public void actualizar(Universidad u) {
		repository.saveAndFlush(u);
	}

	@Override
	public void eliminar(Integer codigo) {
		repository.deleteById(codigo);
	}

	@Override
	public Universidad buscar(Integer codigo) {
		return repository.findById(codigo).orElse(null);
	}

	@Override
	public List<Universidad> listar() {
		return repository.findAll();
	}

}
