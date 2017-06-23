/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula03;

import br.com.crescer.lista02.*;


/**
 *
 * @author lucas.damaceno
 */
public class Select {

    public static void main(String[] args) {
        
        FileUtils verCaminho = new FileUtilsImpl();
        System.out.println(verCaminho.ls("TestarSQL.sql"));
        TesteDAO testando = new TesteDAO();
        SQLUtils teste = new SQLUtilsImpl();
        
        System.out.println(teste.executeQuery("SELECT * FROM ESTADO"));
         
    }
}




