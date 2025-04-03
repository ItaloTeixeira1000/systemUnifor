package com.unifor.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.unifor.system.exception.ResourceNotFoundException;
import com.unifor.system.models.Aluno;
import com.unifor.system.repositories.AlunoRepository;

@Service
public class AlunoService {
	 @Autowired
	    AlunoRepository alunoRepository;

	    public List<Aluno> listAll() {
	        return alunoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	    }

	    public Aluno getById(Long id) throws Exception {
	        return alunoRepository.findById(id).orElseThrow(() -> new Exception("Não foi possivel encontrar o curso com o id: " + id.toString() + "."));
	    }

	    public Aluno save(Aluno aluno) throws Exception {
	        return alunoRepository.save(aluno);
	    }

	    public Aluno update(Aluno updatedAluno, Long id) throws Exception {
	        return this.alunoRepository.findById(id)
	                .map(alunoDB -> {
	                    alunoDB = updatedAluno;
	                    return alunoRepository.save(alunoDB);
	                })
	                .orElseThrow(() -> new ResourceNotFoundException(id));
	    }

	    public void delete(Long id) {
	        if (!alunoRepository.existsById(id)) {
	            throw new ResourceNotFoundException(id);
	        }
	        alunoRepository.deleteById(id);
	    }
}
