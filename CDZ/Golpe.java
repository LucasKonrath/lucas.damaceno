public class Golpe{
    private String nome;
    private int fatorDano;

    public Golpe(String nome, int fatorDano){
        this.nome = nome;
        this.fatorDano = fatorDano;
    }

    public String getNomeGolpe(){
        return this.nome;
    }

    public int getFatorDanoDoGolpe(){
        return this.fatorDano;
    }
}