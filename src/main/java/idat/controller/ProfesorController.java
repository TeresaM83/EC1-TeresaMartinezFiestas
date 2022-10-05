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

import idat.model.Profesor;
import idat.service.ProfesorService;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

	Profesor obj;
	@Autowired
	private ProfesorService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> listar() {
		List<Profesor> lista=service.listar();		
		return new ResponseEntity<List<Profesor>>(lista,HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/{codigo}")
	public ResponseEntity<Profesor> buscar(@PathVariable Integer codigo) {	
		obj = service.buscar(codigo);
		if (obj!=null) {
			return new ResponseEntity<Profesor>(obj,HttpStatus.OK);
		}else {
			return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Profesor> create(@RequestBody Profesor p) {
		service.save(p);	
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{codigo}")
	public ResponseEntity<?> actualizar(@RequestBody Profesor p, @PathVariable Integer codigo) {
		obj= service.buscar(codigo);
		if (obj!=null) {
			p.setIdprofesor(codigo);
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
