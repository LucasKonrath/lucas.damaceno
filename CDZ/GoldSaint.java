public class GoldSaint extends Saint{
    public GoldSaint(String nome, String constelacao) throws Exception{
    this(nome, new Armadura(new Constelacao(constelacao), Categoria.OURO));
    
    }
    public GoldSaint(String nome, Armadura armadura) throws Exception{
    super(nome,armadura);
    this.qtdSentidosDespertados = 7;
                String constelacao = this.getNomeConstelacao();
                if(!constelacao.equals("Áries") && !constelacao.equals("Touro") && !constelacao.equals("Gêmeos") && !constelacao.equals("Câncer") 
                && !constelacao.equals("Leão")&& !constelacao.equals("Virgem")&& !constelacao.equals("Libra")&& !constelacao.equals("Escorpião")
                && !constelacao.equals("Sagitário")&& !constelacao.equals("Capricórnio")&& !constelacao.equals("Aquário")&& !constelacao.equals("Peixes")){
        //dar erro
                throw new Exception("Constelacao invali da");
    
                }
    }
    public void moverNaVelocidadeDaLuz(){
            System.out.println(this.getNome() + " decolando na velocidade da luz.");
    }
	public void imprimirNomeETitulo(){
			System.out.println(super.getNome() + " de " + super.getNomeConstelacao() + ", Cavaleiro de Ouro.");
	}
    
}