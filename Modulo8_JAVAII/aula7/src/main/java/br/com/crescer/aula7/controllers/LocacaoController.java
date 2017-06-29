/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.controllers;


import br.com.crescer.aula7.Locacao;
import br.com.crescer.aula7.services.LocacaoService;
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
public class LocacaoController {

    @Autowired
    private LocacaoService ls;

    @GetMapping(value = "/locacao")
    Iterable<Locacao> toIndex() {        
        return ls.listAll();
    }
    
    @GetMapping(value = "/locacao/{ID}")
    public Locacao loc (@PathVariable Long ID){
    
        return ls.getById(ID);
    }
    
    @PostMapping(value = "/locacao")
    public void adicionar(@RequestBody Locacao loc) {
        ls.addLocacao(loc);
    }
    
    @PutMapping(value = "/locacao")
    public void modificar(@RequestBody Locacao loc) {
        ls.addLocacao(loc);
    }
    
    @DeleteMapping(value = "/locacao/{ID}")
    public void deletarLocacao(@PathVariable Long ID){
        ls.deletar(ls.getById(ID));
    }

}