
public enum Categoria
{
    // OURO CHAMA CONSTRUTOR COM VALOR 3, PRATA CHAMA COM VALOR 2, BRONZE COM VALOR 1
    OURO(3), PRATA(2), BRONZE(1);
    
    private int valor;
    
   private Categoria(int valor){
    	this.valor = valor;
   }
   public int getValor(){
        return this.valor;
   }
}
