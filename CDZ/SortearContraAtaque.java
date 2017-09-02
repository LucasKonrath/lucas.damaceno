public class SortearContraAtaque{
    private Sorteador sorteador;
    public SortearContraAtaque(Sorteador sorteador){
    this.sorteador = sorteador;
    }
    
    public boolean vaiContraAtacar(){
    int numero = this.sorteador.sortear();
    return numero % 3 != 0;
    }
   
}