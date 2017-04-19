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
    public void ordernar(){
        Saint temp,arr;
        for(int i=0;i<listaDeSaints.size();i++){
            for (int j = 0; j<listaDeSaints.size()-1;j++){
                if(listaDeSaints.get(j).getVida() > listaDeSaints.get(j+1).getVida()) {
                    arr = listaDeSaints.get(j);
                    temp=listaDeSaints.get(j+1);
                    listaDeSaints.set(j,temp);
                    listaDeSaints.set(j+1,arr);
                } 
            }
        }
    }
    /*
    public void separarPorVidaCrescente(){
        Collections.sort(listaDeSaints);
    }
    */
    
}   