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
                default:
                break;

            }
        }
        int tamanho = bronze.size();
        int tamanho2 = silver.size();
        int tamanho3 = gold.size();
        for (int x=0; x<bronze.size();x++){
            this.listaOrdenada.add(bronze.get(x));
            if(silver.size() > 0 && x<silver.size()) this.listaOrdenada.add(silver.get(x));
            if(gold.size()>0 && x<gold.size()) this.listaOrdenada.add(gold.get(x));
        }
       
    }

    public ArrayList<Saint> getListaOrdenada(){
        return this.listaOrdenada;
    }

    public void limparLista(){
        this.lista.clear();
    }
}
