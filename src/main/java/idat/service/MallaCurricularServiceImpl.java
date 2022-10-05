package idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.model.MallaCurricular;
import idat.repository.MallaCurricularRepository;
@Service

public class MallaCurricularServiceImpl implements MallaCurricularService {
	
	@Autowired
	private MallaCurricularRepository repository;
	
	@Override
	public void save(MallaCurricular m) {
		repository.save(m);
	}

	@Override
	public void actualizar(MallaCurricular m) {
		repository.saveAndFlush(m);
	}

	@Override
	public void eliminar(Integer codigo) {
		repository.deleteById(codigo);
	}

	@Override
	public MallaCurricular buscar(Integer codigo) {
		return repository.findById(codigo).orElse(null);
	}

	@Override
	public List<MallaCurricular> listar() {
		return repository.findAll();
	}

}
