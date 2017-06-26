/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;

import javax.persistence.*;
import org.hibernate.Session;
import java.util.List;

/**
 *
 * @author lucas.damaceno
 */
public class Run {

    public static void main(String[] args) {

        CrudDao generos = new GeneroDao();
        CrudDao clientes = new ClienteDao();
        CrudDao funcionarios = new FuncionarioDao();
        CrudDao locacoes = new LocacaoDao();
        VideoDao videos = new VideoDao();
    
        Locacao loc = new Locacao();
        
        Funcionario func = (Funcionario) funcionarios.loadById(1l);
        Cliente cli = (Cliente) clientes.loadById(1l);
        Video vid = (Video) videos.loadById(1l);
        
        loc.setFuncionario(func);
        loc.setCliente(cli);
        loc.setVideo(vid);
        loc.setValorTotal(122.22);
        
        locacoes.save(loc);
    }

}
