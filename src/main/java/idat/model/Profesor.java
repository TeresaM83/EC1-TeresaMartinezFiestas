package idat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="profesores")
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idprofesor;
	private String profesor;
	public Integer getIdprofesor() {
		return idprofesor;
	}
	public void setIdprofesor(Integer idprofesor) {
		this.idprofesor = idprofesor;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public Profesor(Integer idprofesor, String profesor) {
		super();
		this.idprofesor = idprofesor;
		this.profesor = profesor;
	}
	public Profesor() {
		super();
	}
	@ManyToMany(mappedBy = "profesores",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Curso> cursos= new ArrayList<>();
}
