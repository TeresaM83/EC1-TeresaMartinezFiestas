package idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
