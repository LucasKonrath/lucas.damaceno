public class GoldSaint extends Saint{
    public GoldSaint(String nome, Armadura armadura) throws Exception{
    super(nome,armadura);
    this.qtdSentidosDespertados = 7;
				String constelacao = this.getConstelacao();
				if(!constelacao.equals("Áries") && !constelacao.equals("Touro")){
		//dar erro
				throw new Exception("Constelacao invalida");
	
				}
    }
    
}