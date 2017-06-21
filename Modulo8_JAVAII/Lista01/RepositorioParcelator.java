/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.lista01;
import java.text.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 *
 * @author lucas.damaceno
 */
public class RepositorioParcelator implements Parcelator{
    
    @Override
    public Map<String, BigDecimal> calcular (BigDecimal valorParcelar, int numeroDeParcelas, double taxaDeJuros, Date dataPrimeiroVencimento){
    
        Map <String, BigDecimal> hm = new LinkedHashMap<String, BigDecimal>();
        BigDecimal um = new BigDecimal(1.00000);
        BigDecimal taxaDeJurosBig = new BigDecimal(taxaDeJuros);
        BigDecimal cemPorcento = new BigDecimal(100.0);
        BigDecimal PorcentagemDosJuros = taxaDeJurosBig.divide(cemPorcento, 2, RoundingMode.HALF_UP);
        PorcentagemDosJuros.add(um);
        BigDecimal valorTotal = valorParcelar.multiply(PorcentagemDosJuros);
        valorTotal = valorTotal.add(valorParcelar);
        BigDecimal valorDeCadaParcela = valorTotal.divide(new BigDecimal(numeroDeParcelas), 2, BigDecimal.ROUND_HALF_UP);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataPrimeiroVencimento);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        int contagem = 0;
        for(int x = 0; x < numeroDeParcelas; x++){
           if(x != 0){
           calendar.add(Calendar.MONTH, 1);
           }
           Date dataImprimir =  calendar.getTime();
           String stringData = df.format(dataImprimir);
           hm.put(stringData, valorDeCadaParcela.divide(um,2,BigDecimal.ROUND_DOWN));
        }
        return hm;
    }
    
}
