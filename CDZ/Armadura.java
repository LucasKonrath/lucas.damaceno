import java.util.ArrayList;
public class Armadura {
	private Constelacao constelacao;
	public Categoria categoria;
	// Construtor da classe Armadura.
	public Armadura(Constelacao constelacao, Categoria categoria){
		this.constelacao = constelacao;
		this.categoria = categoria;
	}
	// Metodo que retorna a constelaçao da armadura.
	public String getNomeConstelacao(){
		return this.constelacao.getNomeConstelacao();
	}
	public int getValorCategoria(){
		return this.categoria.getValor();
	}
	public ArrayList getGolpes(){
	   return constelacao.getGolpes();
	   }
	public void aprenderGolpe(Golpe golpe){
	   this.constelacao.aprenderGolpe(golpe);
	   }
	public Golpe getProximoGolpe() throws Exception{
	   return this.constelacao.getProximoGolpe();
	   }
}