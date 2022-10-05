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

import idat.model.Universidad;
import idat.service.UniversidadService;

@RestController
@RequestMapping("/universidad")
public class UniversidadController {

	Universidad obj;
	@Autowired
	private UniversidadService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Universidad>> listar() {
		List<Universidad> lista=service.listar();		
		return new ResponseEntity<List<Universidad>>(lista,HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/{codigo}")
	public ResponseEntity<Universidad> buscar(@PathVariable Integer codigo) {	
		obj = service.buscar(codigo);
		if (obj!=null) {
			return new ResponseEntity<Universidad>(obj,HttpStatus.OK);
		}else {
			return new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Universidad> create(@RequestBody Universidad p) {
		service.save(p);	
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{codigo}")
	public ResponseEntity<?> actualizar(@RequestBody Universidad p, @PathVariable Integer codigo) {
		obj= service.buscar(codigo);
		if (obj!=null) {
			p.setIduniversidad(codigo);
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
