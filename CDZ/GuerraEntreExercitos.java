public class GuerraEntreExercitos{
    ExercitoDeSaints atacante;
    ExercitoDeSaints defensor;
    public GuerraEntreExercitos(ExercitoDeSaints atacante, ExercitoDeSaints defensor){
    this.atacante = atacante;
    this.defensor = defensor;
    }
    public void iniciar() throws Exception{
        for(int x = 0;  x<atacante.getListaOrdenada().size();x++){
            Saint queAtaca = atacante.getListaOrdenada().get(x);
            Saint queDefende = defensor.getListaOrdenada().get(x);
            queAtaca.adicionarMovimento(new Golpear(queAtaca,queDefende));
            queDefende.adicionarMovimento(new Golpear(queDefende,queAtaca));
            Batalha epica = new Batalha(queAtaca, queDefende);
            epica.iniciar();
        }
        atacante.limparLista();
        defensor.limparLista();
           
    }
    




}