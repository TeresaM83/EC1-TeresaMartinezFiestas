package idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import idat.model.Curso;
import idat.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	Curso obj;
	@Autowired
	private CursoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> listar() {
		List<Curso> lista=service.listar();		
		return new ResponseEntity<List<Curso>>(lista,HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/{codigo}")
	public ResponseEntity<Curso> buscar(@PathVariable Integer codigo) {	
		obj = service.buscar(codigo);
		if (obj!=null) {
			return new ResponseEntity<Curso>(obj,HttpStatus.OK);
		}else {
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Curso> create(@RequestBody Curso p) {
		service.save(p);	
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{codigo}")
	public ResponseEntity<?> actualizar(@RequestBody Curso p, @PathVariable Integer codigo) {
		obj= service.buscar(codigo);
		if (obj!=null) {
			p.setIdcurso(codigo);
			service.actualizar(p);
			return new ResponseEntity<>(p,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
			
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/{codigo}")
	public ResponseEntity<?> eliminar(@PathVariable Integer codigo) {
		obj= service.buscar(codigo);
		if (obj!=null) {
			service.eliminar(codigo);	
			return new ResponseEntity<>(obj,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
