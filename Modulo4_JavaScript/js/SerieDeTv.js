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

function SerieDeTV(nome, anoEstreia){

this.nome = nome || 'NI';
this.anoEstreia = anoEstreia;

}

SerieDeTV.prototype.imprimirNome = function(){

    console.log(this.nome);

}


// Syntactic sugar

    class SerieDeTv2{
        constructor(nome,AnoEstreia){
            this.nome = nome || 'NI';
            this.anoEstreia = AnoEstreia;
        }
        
        imprimirNome(){

            console.log(this.nome.toUpperCase())
        }

    }


