// Classe Saint (Cavaleirxs que entregam justiça cósmica.)
public class Saint {
    public String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero=Genero.NAO_INFORMADO;
    private Status status=Status.VIVO;
    private double vida = 100.0;
	protected int qtdSentidosDespertados;
// Construtor da classe Saint
    public Saint(String nome, Armadura armadura) throws Exception{
        	this.armadura=armadura;
        	this.nome=nome;
		if(this.getCategoriaArmadura() == 2) {
			this.qtdSentidosDespertados = 6;
		}
			else if (this.getCategoriaArmadura() == 3){
				this.qtdSentidosDespertados = 7;
				String constelacao = this.armadura.getConstelacao();
				if(!constelacao.equals("Áries") && !constelacao.equals("Touro")){
		//dar erro
				throw new Exception("Constelacao invalida");
	
				}
			}		
		}     
    
// Método para vestir armadura do Saint.    
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }
// Método para despir armadura do Saint.
	public void despirArmadura(){
		this.armaduraVestida = false;
	}
// Método para checar se Saint esta com armadura vestida.
    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }
// Método para checar gênero do Saint.
    public Genero getGenero(){
    	return this.genero;
    }
// Método para alterar gênero do Saint.
    public void setGenero(Genero genero){
    	this.genero=genero;
    }
// Método para retornar Status do saint.
    public Status getStatus(){
    	return this.status;
    }
 // Método para alterar Status do saint.
    public void setStatus(Status status){
    	this.status = status;
    }

// Metodo que causa dano no Saint.
    public void perderVida(double dano) {
    	this.vida -= dano;
    }
// Metodo que retorna a vida atual do Saint.
    public double getVida(){
    	return this.vida;
    }
// Metodo que retorna o valor numerico da Categoria da Armadura do Saint (Ex: Ouro 3, Prata 2, Bronze 1)
    public int getCategoriaArmadura(){
    	return this.armadura.getValorCategoria();
    }
	public String getConstelacao(){
		return this.armadura.getConstelacao();
	}

	@Override
	public String toString() {
		return nome + " de " +  getConstelacao();
	}
	public int getQtdSentidosDespertados(){
	return this.qtdSentidosDespertados;
	}
    
}
