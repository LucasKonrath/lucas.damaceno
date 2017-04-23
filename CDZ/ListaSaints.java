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
        this.ordenar(TipoOrdenacao.ASCENDENTE);
    }

    public void ordenar(TipoOrdenacao tipo){
        boolean posicoesSendoTrocadas;
        boolean comparacaoAscendente=true;
        if(tipo == TipoOrdenacao.DESCENDENTE) comparacaoAscendente = false;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.listaDeSaints.size() - 1; i++) {
                Saint atual = this.listaDeSaints.get(i);
                Saint proximo = this.listaDeSaints.get(i + 1);

                boolean precisaTrocar = comparacaoAscendente ? atual.getVida() > proximo.getVida() : atual.getVida() < proximo.getVida();
                if (precisaTrocar) {
                    this.listaDeSaints.set(i, proximo);
                    this.listaDeSaints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);   
    }

    public ListaSaints unir (ListaSaints listaRecebida){
        ArrayList<Saint> nova = new ArrayList<>();
        ArrayList<Saint> arrayRecebido = listaRecebida.todos();
        nova = this.todos();
        nova.addAll(arrayRecebido);
        ListaSaints listaNova = new ListaSaints();
        for(int x=0;x<nova.size();x++){
            listaNova.adicionaSaint(nova.get(x));

        }
        return listaNova;
    }

    public ListaSaints diff (ListaSaints listaRecebida){
        ListaSaints listaDosDiferentes = new ListaSaints();
        ArrayList<Saint> arrayRecebido = listaRecebida.todos();
        boolean nenhumIgual;
        for(int i = 0; i<this.listaDeSaints.size();i++){
            nenhumIgual=true;
            for(int j=0; j<arrayRecebido.size();j++){
                if (listaDeSaints.get(i).equals(arrayRecebido.get(j))) nenhumIgual = false;
            }
            if(nenhumIgual) listaDosDiferentes.adicionaSaint(listaDeSaints.get(i));
        }
        return listaDosDiferentes;

    }

    public String getCSV(){
        StringBuilder csv = new StringBuilder(512);
        String prefix = "";
        for(int x = 0; x<this.listaDeSaints.size();x++){
            Saint saint = this.listaDeSaints.get(x);
            String csvDoSaint = saint.getCSV();
            csv.append(prefix);
            prefix = (System.getProperty("line.separator"));
            csv.append(csvDoSaint);
        }
        return csv.toString();
    }
}
/*
public void separarPorVidaCrescente(){
Collections.sort(listaDeSaints);
=======
>>>>>>> f95a3ac... fix(ListaSaints):adicionada categoria da armadura à string CSV.
}
}
/*
public void separarPorVidaCrescente(){
Collections.sort(listaDeSaints);
}
 */

   