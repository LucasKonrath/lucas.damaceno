import java.util.ArrayList;
public class ExercitoQueAtacaEmOrdemHierarquica implements ExercitoDeSaints{
    ArrayList<Saint> lista = new ArrayList<>();
    ArrayList<Saint> listaOrdenada = new ArrayList<>();
    
    public ExercitoQueAtacaEmOrdemHierarquica(){
           
    }
    public void alistar(Saint saint){
        this.lista.add(saint);
        this.ordenar();
    }

    public void ordenar(){
        listaOrdenada.clear();
        for(int x = 0; x<this.lista.size();x++){
           Saint test = this.lista.get(x); 
           if(test.getCategoriaArmadura() == 1 ){
                this.listaOrdenada.add(test);
                
           }
            
        }
        for(int x = 0; x<this.lista.size();x++){
           Saint test = this.lista.get(x); 
           if(test.getCategoriaArmadura() == 2 ){
                this.listaOrdenada.add(test);
               
           }
            
        }
        for(int x = 0; x<this.lista.size();x++){
           Saint test = this.lista.get(x); 
           if(test.getCategoriaArmadura() == 3 ){
                this.listaOrdenada.add(test);
              
           }
            
        }
       

    }
    public ArrayList<Saint> getListaOrdenada(){
    return this.listaOrdenada;
    }
    public void limparLista(){
        this.lista.clear();
    }
}

