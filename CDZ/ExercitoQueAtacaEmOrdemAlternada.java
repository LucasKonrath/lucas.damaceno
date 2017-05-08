import java.util.ArrayList;
public class ExercitoQueAtacaEmOrdemAlternada extends ListaSaints implements ExercitoDeSaints {
    ArrayList<Saint> lista = new ArrayList<>();
    ArrayList<Saint> listaOrdenada = new ArrayList<>();
    public void alistar(Saint saint){
        this.lista.add(saint);
        if(lista.size() % 3 == 0) this.ordenar();
    }

    public void ordenar(){
        Saint test;
         ArrayList<Saint> bronze = new ArrayList<>();
         ArrayList<Saint> silver = new ArrayList<>();
         ArrayList<Saint> gold = new ArrayList<>();
        this.listaOrdenada.clear();
        for(int x=0; x<this.lista.size();x++){
            
            test = this.lista.get(x);
            switch (test.getCategoriaArmadura()){

                case 1:
                bronze.add(test);
                break;
                case 2:
                silver.add(test);
                break;
                case 3:
                gold.add(test);
                break;

                
            }

        }
        int proximaAPegar=1;
        int tamanho = lista.size();
        /*while(listaOrdenada.size() < tamanho){
        for(int index=0; index<lista.size();index++){
        test = this.lista.get(index);
        if(test.getCategoriaArmadura() == proximaAPegar){
        listaOrdenada.add(test);
        }
        proximaAPegar++;
        if(proximaAPegar == 4) proximaAPegar=1;
        }
        }
         */
    }
}
