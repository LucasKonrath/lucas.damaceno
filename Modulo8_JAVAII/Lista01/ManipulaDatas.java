/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.lista01;
import java.util.*;
/**
 *
 * @author lucas
 */
public class ManipulaDatas implements CalendarUtils{
    
    @Override
    public DiaSemana diaSemana(Date dataRecebida){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataRecebida);
        int diaDaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        DiaSemana diaARetornar = DiaSemana.DOMINGO;
        switch(diaDaSemana){
            case 1:
                diaARetornar = DiaSemana.DOMINGO;
                break;
            case 2:
                diaARetornar = DiaSemana.SEGUNDA_FEIRA;
                break;
            case 3:
                diaARetornar = DiaSemana.TERCA_FEIRA;
                break;
            case 4:
                diaARetornar = DiaSemana.QUARTA_FEIRA;
                break;
            case 5:
                diaARetornar = DiaSemana.QUINTA_FEIRA;
                break;
            case 6:
                diaARetornar = DiaSemana.SEXTA_FEIRA;
                break;
            case 7:
                diaARetornar = DiaSemana.SABADO;
                break;
            default:
                System.out.println("Ops. Erro");
                break;
        }
        return diaARetornar;
    }
    
    @Override
    public String tempoDecorrido (Date dataRecebida){
    
        Date dataAtual = new Date();
        Calendar calendarNovo = Calendar.getInstance();
        calendarNovo.setTime(dataAtual);
        Calendar calendarAntigo = Calendar.getInstance();
        calendarAntigo.setTime(dataRecebida);
        int difAnos = calendarNovo.get(Calendar.YEAR) - calendarAntigo.get(Calendar.YEAR);
        int difMeses = calendarNovo.get(Calendar.MONTH) - calendarAntigo.get(Calendar.MONTH);
        int difDias = calendarNovo.get(Calendar.DAY_OF_MONTH) - calendarAntigo.get(Calendar.DAY_OF_MONTH);
        String aSerRetornada = " Tempo decorrido: \n Anos: " + difAnos + " Meses: " + difMeses + " Dias: " + difDias;
        return aSerRetornada;
    }
    
    
    public Date adicionarDiasAUmaData(Date dataRecebida, int qtdDias){
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataRecebida);
        calendar.add(Calendar.DAY_OF_MONTH,qtdDias);
        return calendar.getTime();
    }
}
