public class SilverSaint extends Saint{
    public SilverSaint(String nome, String constelacao) throws Exception{
    super(nome,constelacao);
    this.qtdSentidosDespertados = 6;
    setCategoria();
    }
    public void setCategoria(){ 
        this.armadura.categoria=Categoria.PRATA;
    }
}
