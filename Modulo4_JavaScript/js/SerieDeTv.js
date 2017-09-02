/*


Classe em Java.

public class SerieDeTv {

    private String nome;
    private int anoEstreia;
public SerieDeTv(String nome, int anoEstreia){

    this.nome = nome;
    this.anoEstreia = anoEstreia;
}

    public String getNome(){return this.nome;}
    public int getAnoEstreia(){return this.anoEstreia;}
    public void setNome(String nome){this.nome = nome;}
    public void setAnoEstreia(int AnoEstreia){this. anoEstreia = anoEstreia;}
    public void imprimirNome(){
        System.out.println(this.nome.toUpperCase());
}

}
*/



// Syntactic sugar

    class SerieDeTv{
        constructor(nome,AnoEstreia){
            this.nome = nome || 'NI';
            this.anoEstreia = AnoEstreia;
        }
        
        // ATRIBUTOS
        // EX: BrBa.nomeSerie outputs "BREAKING BAD"
        get nomeSerie(){

           return this.nome.toUpperCase();
        }
        
        // ATRIBUTOS
        // EX: BrBa.nomeSerie = "A quimica do mal" muda o valor de BrBa.nome
        set nomeSerie(valor){
            
            this.nome = valor;
            
        }
        static verificarClassificacaoIndicativa(){
            
            return "13 anos.";
            
        }
        
        
    }


