public class Constelacao{
    private String nome;
    private Golpe[] meusGolpes = new Golpe[3];
    private int acumuladorProximoGolpe=0;
        
        public Constelacao(String nome){
            this.nome = nome;
        }
    
        public void aprenderGolpe(Golpe golpe){
            for (int i = 0; i<this.meusGolpes.length;i++){
                if(meusGolpes[i] == null){
                    this.meusGolpes[i] = golpe;
                    break;
                }
            }
        }
      
    
        public String getNomeConstelacao(){
        return this.nome;
        }
        
        public Golpe[] getGolpes(){
        return this.meusGolpes;
        }
   
        public Golpe getProximoGolpe() throws Exception{
            if(meusGolpes[0] == null) throw new Exception("Array não-populado"); 
            meusGolpes = getGolpes();
            int posicao = acumuladorProximoGolpe % meusGolpes.length;
            this.acumuladorProximoGolpe++;
            return meusGolpes[posicao];
        }
}