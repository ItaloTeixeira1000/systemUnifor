package com.unifor.system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifor.system.models.Curso;
import com.unifor.system.services.CursoService;

@RestController
@RequestMapping("/curso/")
public class CursoController {
    @Autowired
    CursoService cursoService;

    @GetMapping
    List<Curso> listAll() {
        return cursoService.listAll();
    }

    @PostMapping
    Curso save(@RequestBody Curso course) throws Exception {
        return cursoService.save(course);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
    	cursoService.delete(id);
    }
}
