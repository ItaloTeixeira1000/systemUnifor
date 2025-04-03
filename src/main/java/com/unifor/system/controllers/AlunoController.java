package com.unifor.system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifor.system.models.Aluno;
import com.unifor.system.services.AlunoService;

@RestController
@RequestMapping("/aluno/")
public class AlunoController {
	@Autowired
    AlunoService alunoService;

    @GetMapping
    List<Aluno> listAll() {
        return alunoService.listAll();
    }

    @GetMapping("{id}")
    Aluno getById(@PathVariable Long id) throws Exception {
        return alunoService.getById(id);
    }

    @PostMapping
    Aluno save(@RequestBody Aluno aluno) throws Exception {
        return alunoService.save(aluno);
    }

    @PutMapping("{id}")
    Aluno update(@RequestBody Aluno aluno, @PathVariable Long id) throws Exception {
        return alunoService.update(aluno, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
    	alunoService.delete(id);
    }
}
