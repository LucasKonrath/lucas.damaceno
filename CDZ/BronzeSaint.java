public class BronzeSaint extends Saint{

    public BronzeSaint(String nome, String constelacao) throws Exception{
        super(nome, constelacao);
        this.qtdSentidosDespertados = 5;
        setCategoria();
    }

    public void setCategoria(){ 
        this.armadura.categoria=Categoria.BRONZE;
        this.categoria=Categoria.BRONZE;
    }
}