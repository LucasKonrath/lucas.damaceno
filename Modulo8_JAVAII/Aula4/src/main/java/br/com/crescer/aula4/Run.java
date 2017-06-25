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
        
        Genero gen = (Genero) generos.loadById(10l);
        Video vid = new Video();
        vid.setNome("Joaozinho dinheiros");
        vid.setGenero(gen);
        vid.setValor(100.2);
        videos.save(vid);
    }

}
