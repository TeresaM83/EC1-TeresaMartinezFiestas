package idat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcurso;
	private String curso;
	private String descripcion;
	
	public Integer getIdcurso() {
		return idcurso;
	}
	public void setIdcurso(Integer idcurso) {
		this.idcurso = idcurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@ManyToOne
	@JoinColumn(
			name="idmalla",
			nullable = false,
			unique = true,
			foreignKey =  @ForeignKey(foreignKeyDefinition ="foreign key(idmalla) references mallacurricular(idmalla)" )
			)
	private MallaCurricular mallacurricular;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name="curso_profesor",
			joinColumns=@JoinColumn(
					name="idcurso",
					nullable = false,
					unique = true,
					foreignKey =  @ForeignKey(foreignKeyDefinition ="foreign key(idcurso) references cursos(idcurso)" )),
		    inverseJoinColumns= @JoinColumn(
		    		name="idprofesor",
					nullable = false,
					unique = true,
					foreignKey =  @ForeignKey(foreignKeyDefinition ="foreign key(idprofesor) references profesores(idprofesor)" ))
	)
	private List<Profesor> profesores= new ArrayList<>();
	
}
