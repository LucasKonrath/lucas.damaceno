public class Constelacao{
    private String nome;
    private Golpe[] meusGolpes = new Golpe[3];
    private int indiceAPopular = 0;
    private int indiceADevolverGolpe = 0;
    private boolean ultimoCadastrado;
    private boolean ultimoGolpeFoiZero;
    public Constelacao(String nome){
    this.nome = nome;
    }
    public void aprenderGolpe(Golpe golpe){
        meusGolpes[indiceAPopular] = golpe;
        if(indiceAPopular<meusGolpes.length-1){
        this.indiceAPopular++;
        }
        else ultimoCadastrado=true;
    }
    public String getNomeConstelacao(){
        return this.nome;
    }
    public Golpe[] getGolpes(){
    return this.meusGolpes;
    }
    public Golpe getProximoGolpe() throws Exception{
    
    if (indiceADevolverGolpe==0 && indiceAPopular==0) throw new Exception ("Nenhum golpe cadastrado");
    else if (indiceADevolverGolpe==0 && indiceAPopular==1) indiceADevolverGolpe=0;
    else if (indiceADevolverGolpe==0 && indiceAPopular==2){ 
        if (ultimoGolpeFoiZero==true) indiceADevolverGolpe=1;
        else indiceADevolverGolpe=0;
    }
    else if (indiceADevolverGolpe==1 && indiceAPopular==2 && ultimoCadastrado==true) indiceADevolverGolpe=2;
    else indiceADevolverGolpe=0;
    if (indiceADevolverGolpe==0) ultimoGolpeFoiZero = true;
    else ultimoGolpeFoiZero = false;
    Golpe golpeADevolver = this.meusGolpes[indiceADevolverGolpe];
    return golpeADevolver;
    }

}