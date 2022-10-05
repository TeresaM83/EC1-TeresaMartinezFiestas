package idat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mallacurricular")
public class MallaCurricular {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmalla;
	private Integer año;
	
	public MallaCurricular(Integer idmalla, Integer año) {
		super();
		this.idmalla = idmalla;
		this.año = año;
	}
	public MallaCurricular() {
		super();
	}
	public Integer getIdmalla() {
		return idmalla;
	}
	public void setIdmalla(Integer idmalla) {
		this.idmalla = idmalla;
	}
	public Integer getAño() {
		return año;
	}
	public void setAño(Integer año) {
		this.año = año;
	}
	
	@OneToOne
	private Universidad universidad;
	
	@OneToMany(mappedBy = "mallacurricular")
	private List<Curso> cursos= new ArrayList<>();
}
