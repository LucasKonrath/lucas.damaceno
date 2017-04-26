public class CriticalHit{
    
   private Sorteador sorteador;
   public CriticalHit(Sorteador sorteador){
    this.sorteador = sorteador;
    }
   public boolean isCriticalHit(){
    int numero = this.sorteador.sortear();
    return numero % 3 == 0;
    }
}