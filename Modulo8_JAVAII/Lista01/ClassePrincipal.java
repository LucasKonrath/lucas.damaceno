/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.lista01;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lucas
 */
public class ClassePrincipal {
    public static void main(String[] args) {
        ManipulaStrings manipulador = new ManipulaStrings();
        ManipulaDatas manipuladorDatas = new ManipulaDatas();
        RepositorioParcelator repoParcelator = new RepositorioParcelator();
        System.out.println("Testando string vazia: " + manipulador.isEmpty(""));
        System.out.println("Testando string povoada: " + manipulador.isEmpty("Povoada."));
        int vogais = manipulador.contaVogais("Batata");
        System.out.println("Contando as vogais de batata: " + vogais );
        System.out.println("Invertendo a string batata: " + manipulador.inverter("batata"));
        System.out.println("Checando se ovo eh palindromo: " + manipulador.isPalindromo("ovo"));
        System.out.println("Checando se vc quebrou o meu ovo eh palindromo: " + manipulador.isPalindromo("vc quebrou o meu ovo"));
        Date dataBase = new Date();
        System.out.println("Checando se hj eh quarta: " + manipuladorDatas.diaSemana(dataBase));
        dataBase = manipuladorDatas.adicionarDiasAUmaData(dataBase, -1);
        System.out.println("Checando se ontem eh terça: " + manipuladorDatas.diaSemana(dataBase));
        dataBase = manipuladorDatas.adicionarDiasAUmaData(dataBase, -4);
        System.out.println("Checando se quatro dias atras eh sexta: " + manipuladorDatas.diaSemana(dataBase));
        System.out.println("Parcelator, man:");
        Map <String, BigDecimal> hm = new HashMap<String, BigDecimal>();
        hm = repoParcelator.calcular(new BigDecimal(2000.0), 4, 4.7, new Date());
        System.out.println(hm);
    }
}
