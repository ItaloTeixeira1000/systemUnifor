package com.unifor.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.unifor.system.exception.ResourceNotFoundException;
import com.unifor.system.models.Curso;
import com.unifor.system.repositories.CursoRepository;

@Service
public class CursoService {
	@Autowired
	CursoRepository cursoRepository;
	
	public List<Curso> listAll() {
        return cursoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
	
	public Curso save(Curso curso) throws Exception {
        return cursoRepository.save(curso);
    }
	
	public void delete(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        cursoRepository.deleteById(id);
    }
}
