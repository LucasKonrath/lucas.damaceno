/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author lucas.damaceno
 */
public class SomarDias {
    
    
    public static void somarData() throws IOException{
        
        Calendar calendar = Calendar.getInstance();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    System.out.println("Digite a data inicial");
    String dataLida = br.readLine();
    System.out.println("Digite a quantidade de dias a somar");
    int diasASomar = Integer.parseInt(br.readLine());
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date dataInicial;
    try {
    dataInicial = df.parse(dataLida);
    calendar.setTime(dataInicial);
    calendar.add(Calendar.DAY_OF_YEAR, diasASomar);
    dataInicial = calendar.getTime();
    String novaStringData = df.format(dataInicial);
    System.out.println(novaStringData);
    } catch (Exception e) {
    e.printStackTrace();
    }
    
    }
    
}
