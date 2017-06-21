/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.lista01;
import java.text.Normalizer;


/**
 *
 * @author lucas
 */
public class ManipulaStrings implements StringUtils {
    @Override
    public  boolean isEmpty(String recebida){
        
        return (recebida.isEmpty());
        
    }
    @Override
    public String inverter (String recebida){
    
        String invertida = new StringBuffer(recebida).reverse().toString();
        return invertida;
        
    }
     
    @Override
    public  int contaVogais(String recebida){
        
        recebida = recebida.toLowerCase();
        recebida = Normalizer.normalize(recebida, Normalizer.Form.NFD);
        recebida = recebida.replaceAll("[^\\p{ASCII}]", "");
        int contagemDeVogais = 0;
        
        for(int letra = 0; letra < recebida.length();letra++){
            switch(recebida.charAt(letra)){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    contagemDeVogais++;
                default:
                    break;
            }
        }
        return contagemDeVogais;
    }
    
    @Override    
    public boolean isPalindromo(String recebida){
        
        recebida = Normalizer.normalize(recebida, Normalizer.Form.NFD);
        recebida = recebida.replaceAll(" ", "");
        recebida = recebida.replaceAll("[^\\p{ASCII}]", "");
        return (recebida.toLowerCase().equals(inverter(recebida.toLowerCase())));
    }
    
}
