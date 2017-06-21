/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.lista01;

/**
 *
 * @author lucas
 */
public class ClassePrincipal {
    public static void main(String[] args) {
        ManipulaStrings manipulador = new ManipulaStrings();
        System.out.println("Testando string vazia: " + manipulador.isEmpty(""));
        System.out.println("Testando string povoada: " + manipulador.isEmpty("Povoada."));
        int vogais = manipulador.contaVogais("Batata");
        System.out.println("Contando as vogais de batata: " + vogais );
        System.out.println("Invertendo a string batata: " + manipulador.inverter("batata"));
        System.out.println("Checando se ovo eh palindromo: " + manipulador.isPalindromo("ovo"));
        System.out.println("Checando se vc quebrou o meu ovo eh palindromo: " + manipulador.isPalindromo("vc quebrou o meu ovo"));
    }
}
