/*


function Jedi(){

    this.nome = "Luke";
    this.ligarSabre = function(){
       // var self = this; Também usado para armazenar valor de this.                                  
                                                            // Forçar valor de this. 
       setInterval(function(){ console.log("JOÃOOOOOOOOOO", this.nome);}.bind(this),2000);

    }
    console.log(this);

}


*/

function Jedi(){
    this.nome="Luke";                               // this léxico. Arrow functions não apresentam o problema de cima.
    this.ligarSabre =function(){ setInterval(() => {console.log("Uóooooom", this.nome);},2000)}

}