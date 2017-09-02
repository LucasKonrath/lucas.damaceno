/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.controllers;


import br.com.crescer.aula7.Funcionario;
import br.com.crescer.aula7.services.FuncionarioService;
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
public class FuncionarioController {

    @Autowired
    private FuncionarioService fs;

    @GetMapping(value = "/funcionario")
    Iterable<Funcionario> toIndex() {        
        return fs.listAll();
    }
    
    @GetMapping(value = "/funcionario/{ID}")
    public Funcionario func (@PathVariable Long ID){
    
        return fs.getById(ID);
    }
    
    @PostMapping(value = "/funcionario")
    public void adicionar(@RequestBody Funcionario func) {
        fs.addFuncionario(func);
    }
    
    @PutMapping(value = "/funcionario")
    public void atualizar(@RequestBody Funcionario func) {
        fs.addFuncionario(func);
    }
    
    @DeleteMapping(value = "/funcionario/{ID}")
    public void deletarCliente(@PathVariable Long ID){
        fs.deletar(fs.getById(ID));
    }

}