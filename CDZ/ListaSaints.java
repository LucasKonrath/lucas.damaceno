import java.util.ArrayList;

public class ListaSaints{
    ArrayList <Saint> listaDeSaints = new ArrayList<>();
    public void adicionaSaint(Saint saint){
        listaDeSaints.add(saint);
    }
    public Saint getIndice(int indice){
        return listaDeSaints.get(indice);
    } 
    public ArrayList todos(){
        return listaDeSaints;
    }
    public void remover(Saint saint){
        listaDeSaints.remove(saint);
    }
    /*  
    public Saint buscarPorNome(String string)throws Exception{
        if (listaDeSaints.getIndexOf(saint.getNome()) ==-1){
        throw new Exception ("Saint não encontrado na lista.");
        }
        return;
    }
    */
}   