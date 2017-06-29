/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.controllers;


import br.com.crescer.aula7.Genero;
import br.com.crescer.aula7.GeneroRepository;
import br.com.crescer.aula7.services.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carlos H. Nonnemacher
 */
@RestController
public class GeneroController {

    @Autowired
    private GeneroService gs;

    @GetMapping(value = "/genero")
    Iterable<Genero> toIndex() {        
        return gs.listAll();
    }
    
    @GetMapping(value = "/genero/{ID}")
    public Genero gen (@PathVariable Long ID){
    
        return gs.getById(ID);
    }
    
    @PostMapping(value = "/genero")
    public void adicionar(@RequestBody Genero gen) {
        gs.addGenero(gen);
    }
    
    @PutMapping(value = "/genero")
    public void atualizar(@RequestBody Genero gen) {
        gs.addGenero(gen);
    }
    
    @DeleteMapping(value = "/genero/{ID}")
    public void deletarGenero(@PathVariable Long ID){
        gs.deletar(gs.getById(ID));
    }

}