import java.util.ArrayList;
public class Constelacao{
    private String nome;
    private ArrayList<Golpe> meusGolpes = new ArrayList<>();
    private int acumuladorProximoGolpe=0;
        
        public Constelacao(String nome){
            this.nome = nome;
        }
    
        public void aprenderGolpe(Golpe golpe){
            this.meusGolpes.add(golpe);
        }
      
    
        public String getNomeConstelacao(){
        return this.nome;
        }
       
        public ArrayList<Golpe> getGolpes(){
        return this.meusGolpes;
        }
      
         
        public Golpe getProximoGolpe() throws Exception{
            if(meusGolpes.get(0) == null) throw new Exception("Array não-populado"); 
            meusGolpes = getGolpes();
            int posicao = acumuladorProximoGolpe % meusGolpes.size();
            this.acumuladorProximoGolpe++;
            return meusGolpes.get(posicao);
        }
          
}