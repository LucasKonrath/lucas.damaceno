import java.util.*;
import java.util.stream.*;

public class ListaSaints{
    ArrayList <Saint> listaDeSaints = new ArrayList<>();
    public void adicionaSaint(Saint saint){
        listaDeSaints.add(saint);
    }
    public Saint getIndice(int indice){
        return listaDeSaints.get(indice);
    } 
    public ArrayList<Saint> todos(){
        return listaDeSaints;
    }
    public void remover(Saint saint){
        listaDeSaints.remove(saint);
    }
      
    public Saint buscarPorNome(String string){
        for(int x = 0; x<listaDeSaints.size();x++){
        Saint test = listaDeSaints.get(x);
        if (test.getNome().equals(string)) {
            return test;   
        }
    }
     return null;   
    }
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria){
       return (ArrayList<Saint>)this.listaDeSaints.stream()
            .filter(s -> s.getArmadura().getCategoria().equals(categoria))
            .collect(Collectors.toList());
    }
        /*
        ArrayList<Saint> listaDaCategoria = new ArrayList<>();
        for (int x = 0; x<listaDeSaints.size();x++){
            Saint test = listaDeSaints.get(x);
            if(test.getCategoriaArmadura() == categoria.getValor()) listaDaCategoria.add(test);
        }
        return listaDaCategoria;
    */ 
    public ArrayList<Saint> buscarPorStatus(Status status){
        return (ArrayList<Saint>)this.listaDeSaints.stream()
            .filter(s -> s.getStatus().equals(status))
           .collect(Collectors.toList());
    } 
    public Saint getSaintMaiorVida(){
        double vida = 0.0;
        Saint saint=null;
        for (int x = 0; x<listaDeSaints.size();x++){
            Saint test = listaDeSaints.get(x);
            if (test.getVida()>vida){
                saint = test;
                vida=test.getVida();
            }
        }
        return saint;
    }
    public Saint getSaintMenorVida(){
        double vida = 100.0;
        Saint saint=null;
        for (int x = 0; x<listaDeSaints.size();x++){
            Saint test = listaDeSaints.get(x);
            if (test.getVida()<vida){
                saint = test;   
                vida=test.getVida();
            }
        }
        return saint;
    }   
    public void ordenar() {
         /*
 +         * BubbleSort
 +         * Complexidade: O(n^2)
 +         * 
 +         * 
 +         *     [4] [3] [60] [17] [10]
 +         * i0: [3] [4] [17] [10] [60]
 +         * i1: [3] [4] [10] [17] [60]
 +         */
         
         boolean posicoesSendoTrocadas;
         do {
            posicoesSendoTrocadas = false;
             for (int i = 0; i < this.listaDeSaints.size() - 1; i++) {
                 Saint atual = this.listaDeSaints.get(i);
                 Saint proximo = this.listaDeSaints.get(i + 1);
                 boolean precisaTrocar = atual.getVida() > proximo.getVida();
                 if (precisaTrocar) {
                     this.listaDeSaints.set(i, proximo);
                     this.listaDeSaints.set(i + 1, atual);
                     posicoesSendoTrocadas = true;
                 }
             }
         } while (posicoesSendoTrocadas);   
     }
     public void ordenar(TipoOrdenacao tipo){
         boolean posicoesSendoTrocadas;
        if(tipo == TipoOrdenacao.ASCENDENTE) this.ordenar();
        else if (tipo == TipoOrdenacao.DESCENDENTE){
        do {
            posicoesSendoTrocadas = false;
             for (int i = 0; i < this.listaDeSaints.size() - 1; i++) {
                 Saint atual = this.listaDeSaints.get(i);
                 Saint proximo = this.listaDeSaints.get(i + 1);
                 boolean precisaTrocar = atual.getVida() < proximo.getVida();
                 if (precisaTrocar) {
                     this.listaDeSaints.set(i, proximo);
                     this.listaDeSaints.set(i + 1, atual);
                     posicoesSendoTrocadas = true;
                 }
             }
         } while (posicoesSendoTrocadas);   
        }
        }
 }
    /*
    public void separarPorVidaCrescente(){
        Collections.sort(listaDeSaints);
    }
    */
    
   