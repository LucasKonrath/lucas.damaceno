import java.util.ArrayList;
public class ExemplosListas{

    public void rodar(){
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Bernardo");
        nomes.add("André Nunes");
        for (int i = 0; i<nomes.size();i++){
            System.out.println(nomes.get(i));
        }

    
        System.out.println("Iterator");
        for(String nome : nomes){
            System.out.println(nome);
        }
    }
}
