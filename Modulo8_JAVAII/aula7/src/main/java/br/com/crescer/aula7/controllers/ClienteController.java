/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.controllers;


import br.com.crescer.aula7.Cliente;
import br.com.crescer.aula7.services.ClienteService;
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
public class ClienteController {

    @Autowired
    private ClienteService cs;

    @GetMapping(value = "/cliente")
    Iterable<Cliente> toIndex() {        
        return cs.listAll();
    }
    
    @GetMapping(value = "/cliente/{ID}")
    public Cliente cli (@PathVariable Long ID){
    
        return cs.getById(ID);
    }
    
    @PostMapping(value = "/cliente")
    public void adicionar(@RequestBody Cliente cli) {
        cs.addCliente(cli);
    }
    
    @PutMapping(value = "/cliente")
    public void atualizar(@RequestBody Cliente cli) {
        cs.addCliente(cli);
    }
    
    @DeleteMapping(value = "/cliente/{ID}")
    public void deletarCliente(@PathVariable Long ID){
        cs.deletar(cs.getById(ID));
    }

}