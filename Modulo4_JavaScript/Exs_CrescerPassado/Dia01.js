
/*

Ex1 : Pirâmide Illuminatti.
Escreva uma função gerarPiramide(niveis) que imprime com console.log uma pirâmide com uma quantidade de níveis informada por parâmetro, utilizando os caracteres R$. Ex:
  gerarPiramide(9);
  R$
  R$R$
  R$R$R$
  R$R$R$R$
  R$R$R$R$R$
  R$R$R$R$R$R$
  R$R$R$R$R$R$R$
  R$R$R$R$R$R$R$R$
  R$R$R$R$R$R$R$R$R$

*/

function gerarPiramide(niveis){
    var string = '';
    for(var x = 0; x < niveis; x++){
        string += 'R$';
        console.log(string);
    }
}


/*

Ex2: Diglett dig, trio trio trio

Escreva uma função diglettDig() que, utilizando console.log, imprime todos os números de 1 até 100, com duas exceções:
quando o número for divisível por 3, imprima 'Diglett dig' invés do número, e
quando o número for divisível por 5 (e não por 3), imprima 'trio trio trio' invés do número.
Após ter essa lógica funcionando, altere a função para imprimir 'Diglett dig, trio trio trio' para números que são divisíveis tanto por 3 quanto por 5 (e que continue imprimindo 'Diglett dig' ou 'trio trio trio' para os números divisíveis apenas por 3 ou 5).

*/
function diglettDig(){
    for( var x = 1; x <= 100; x++){

        if(x % 3 === 0 && x % 5 === 0){
            console.log('Diglett dig, trio trio trio');

        }
        else if(x % 3 === 0) {
            console.log('Diglett dig');

        }
        else if ( x % 5 === 0){
            console.log('trio trio trio')

        }
        else{
            console.log(x);
        }

    }
}


/*

3. Funções por parâmetro!?

Crie uma função chamada find que recebe um array e uma função por parâmetro. A função (passada por parâmetro) deverá informar um critério de busca de elementos dentro do array e a função find utilizará este critério para retornar todos elementos do array que encontram-se dentro dele. NÃO SURTEM! 

*/

function maiorIgualA2(element){
    return element >= 2;
}

function find(arrayRecebido , funcao){

    var segundoArray = [];
    
    if(typeof funcao !== 'function'){
        
        console.log("Isso ai nao e uma funcao mano.");
        return null;
        
    }
    for(var x = 0; x < arrayRecebido.length; x++){
        
        if(funcao(arrayRecebido[x]) === true){
            segundoArray.push(arrayRecebido[x]);
        }
        
    }
    return segundoArray;
}














