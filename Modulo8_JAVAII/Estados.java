/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.util.*;

/**
 *
 * @author lucas.damaceno
 */
enum Estados {
    AC("Acre"), AL("Alagoas"), ES("EspíritoSanto"), AP("Amapá"),
    BA("Bahia"), CE("Ceará"), DF("DistritoFederal"), GO("Goiás"),
    MA("Maranhão"), SC("SantaCatarina"), MG("MinasGerais"),
    MT("MatoGrosso"), MS("MatoGrossodoSul"), PA("Pará"),
    RS("RioGrandedoSul"), PE("Pernambuco"), PI("Piauí"),
    AM("Amazonas"), PR("Paraná"), RJ("RiodeJaneiro"),
    RN("RioGrandedoNorte"), PB("Paraíba"), RO("Rondônia"),
    RR("Roraima"), SE("Sergipe"), SP("SãoPaulo"), TO("Tocantins");

    private String nome;

    private Estados(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public static void imprimirNomes(){
    StringBuffer tmp = new StringBuffer();
    int contagem = 0;
        for(Estados estado: Estados.values()){
            if(contagem != 0)
                tmp.append(',');
            tmp.append(estado.getNome());
            contagem++;
            
        }
        
        String estados = tmp.toString();
        List<String> listaDeEstados = new ArrayList<>(Arrays.asList(estados.split(",")));
        listaDeEstados.sort(null);
        System.out.println(listaDeEstados.toString());
        
    }

}