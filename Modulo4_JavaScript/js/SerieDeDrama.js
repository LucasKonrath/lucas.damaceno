// Herança. 

class SerieDeDrama extends SerieDeTv{


    constructor(nome,anoEstreia){
            super(nome, anoEstreia);
        }
    
    get mediaDeMortesPorEpisodio(){

        return 12;
    }

}