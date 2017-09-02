public class SorteDoDia{
    private Sorteador sorteador;
    private int resultado;
    public SorteDoDia(Sorteador sorteador){
        this.sorteador = sorteador;
    }

    public boolean estouComSorte(){
        int resultado = this.sorteador.sortear();
        this.resultado = resultado;
        return resultado % 2 == 0;
    }
    
    public boolean estouComSorte(int sorteado){
        return sorteado % 2 == 0;
    }

}