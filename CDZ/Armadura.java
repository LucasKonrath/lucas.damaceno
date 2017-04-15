public class Armadura {
	private String constelacao;
	public Categoria categoria;
	// Construtor da classe Armadura.
	public Armadura(String constelacao, Categoria categoria){
		this.constelacao = constelacao;
		this.categoria = categoria;
	}
	// Metodo que retorna a constelaçao da armadura.
	public String getConstelacao(){
		return this.constelacao;
	}
	public int getValorCategoria(){
		return this.categoria.getValor();
	}
}