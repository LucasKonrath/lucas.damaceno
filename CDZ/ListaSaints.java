import java.util.*;

public class ListaSaints{
    ArrayList <Saint> listaDeSaints = new ArrayList<>();
    public void adicionaSaint(Saint saint){
        listaDeSaints.add(saint);
    }
    public Saint getIndteice(int indice){
        return listaDeSaints.get(indice);
    } 
    public ArrayList todos(){
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
        ArrayList<Saint> listaDaCategoria = new ArrayList<>();
        for (int x = 0; x<listaDeSaints.size();x++){
            Saint test = listaDeSaints.get(x);
            if(test.getCategoriaArmadura() == categoria.getValor()) listaDaCategoria.add(test);
        }
        return listaDaCategoria;
    } 
    public ArrayList<Saint> buscarPorStatus(Status status){
        ArrayList<Saint> listaPeloStatus = new ArrayList<>();
        for (int x = 0; x<listaDeSaints.size();x++){
            Saint test = listaDeSaints.get(x);
            if(test.getStatus().equals(status)) listaPeloStatus.add(test);
        }
        return listaPeloStatus;
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
   	public void separarPorVidaCrescente(){
		Collections.sort(listaDeSaints);
	}
	
}   