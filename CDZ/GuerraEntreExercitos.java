public class GuerraEntreExercitos{
    ExercitoDeSaints atacante;
    ExercitoDeSaints defensor;
    public GuerraEntreExercitos(ExercitoDeSaints atacante, ExercitoDeSaints defensor){
    this.atacante = atacante;
    this.defensor = defensor;
    }
    public void iniciar() throws Exception{
        for(int x = 0;  x<atacante.getListaOrdenada().size();x++){
            Batalha epica = new Batalha(atacante.getListaOrdenada().get(x), defensor.getListaOrdenada().get(x));
            epica.iniciar();
        }
            defensor.getListaOrdenada().clear();
            atacante.getListaOrdenada().clear();
    }
    




}