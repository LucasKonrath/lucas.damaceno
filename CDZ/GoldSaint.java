public class GoldSaint extends Saint{
    public GoldSaint(String nome, String constelacao) throws Exception{   
        super(nome,constelacao);
        this.qtdSentidosDespertados = 7;
        if(!constelacao.equals("Áries") && !constelacao.equals("Touro") && !constelacao.equals("Gêmeos") && !constelacao.equals("Câncer") 
        && !constelacao.equals("Leão")&& !constelacao.equals("Virgem")&& !constelacao.equals("Libra")&& !constelacao.equals("Escorpião")
        && !constelacao.equals("Sagitário")&& !constelacao.equals("Capricórnio")&& !constelacao.equals("Aquário")&& !constelacao.equals("Peixes")){
            throw new Exception("Constelacao invalida");
        }
        setCategoria();
    }

    public void setCategoria(){ 
        this.armadura.categoria=Categoria.OURO;
        this.categoria = Categoria.OURO;
    }

}