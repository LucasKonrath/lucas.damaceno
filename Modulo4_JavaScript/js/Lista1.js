
/*
Daisy Game!

Faça uma função chamada daisyGame que receba por argumento o número de pétalas da margarida e retorne 'Love me' ou 'Love me not' (Lembre do jogo "Bem me quer, mal me quer"). Exemplo:

daisyGame(4); // retorna 'Love me not'
*/

function daisyGame(a){
    if(a % 2 == 0) return "Loves Me Not"
    else return "Loves Me"
}

/*

Exercício 2

Maior texto

Faça uma função chamada maiorTexto que receba um array de strings e retorne o texto com maior número de caracteres.

*/

function maiorTexto (arrayDeStrings){
    var numeroMaior=0;
    for(string of arrayDeStrings){
        if(string.length >= numeroMaior){
            var stringMaior = string;
            numeroMaior = string.length;
        }
    }
    return stringMaior;
}

/*
Para testar:

var batatasVariadas = new Array("Batata", "Batatao", "Batata-Gigante", "Batata Mega Hiper Blaster Chuck Norris");
maiorTexto(batatasVariadas);

*/

/*

Exercício 3

Instrutor querido

Faça uma função chamada imprime que receba dois parâmetros:

Um array de strings; e
Uma função.
Dentro da função imprime chame a função do segundo parâmetro para cada elemento do array. Exemplo:

imprime(
  // primeiro parâmetro: array
  [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ],
  // segundo parâmetro: função
  function(instrutor) {
   console.log('olá querido instrutor:', instrutor)
  }
);
Deve resultar em:

"olá querido instrutor: bernardo"
"olá querido instrutor: nunes"
"olá querido instrutor: fabrício"
"olá querido instrutor: ben-hur"
"olá querido instrutor: carlos"

Atenção! Faça um tratamento para evitar que a função imprime seja chamada com um segundo parâmetro que não seja uma função, por exemplo:

imprime([ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ], 3.14);
// Jabulani:
// 'TypeError: number is not a function'

*/

function imprime(arrayDeStrings, funcao){
    if(typeof funcao === "function"){  
        for(string of arrayDeStrings){

            funcao(string);


        }

    }
    else {
        console.log("TypeError:" + (typeof funcao) + " is not a function");        
    }
}

/*

Exercício 4

Soma diferentona

Escreva uma função somar que permite somar dois números através de duas chamadas diferentes (não necessariamente pra mesma função). Pirou? Ex:

adicionar(3)(4); // 7
adicionar(5642)(8749); // 14391

*/

function somar(a){
    
        function somarComA(b){
            return a+b;
        }
    
    return somarComA;
}

/*


Fibona

Faça uma função fiboSum que calcule a soma da sequência de Fibonacci para n números informados. Exemplo de chamada:

fiboSum(7);
// 33 (soma dos 7 primeiros números da sequência: 1+1+2+3+5+8+13)
Dica: aproveite toda "beleza" dos algoritmos recursivos! #sqn

*/

function fibonacci(termo){
    if(termo == 2 || termo == 1) return 1;
    else return (fibonacci(termo-1) + fibonacci(termo-2));
}

function sumFibonacci(numeroTermo){
    var soma = 0;
    for(var contagem = numeroTermo; contagem>0; contagem--){
        soma += fibonacci(contagem);
    }
    return soma;
}

/*

    Exercício 6

Quero café

Escreva uma função queroCafe que recebe dois parâmetros:

mascada: Valor numérico
precos: Lista de preços de café
A sua implementação deve retornar uma string com todos os preços que estão abaixo ou igual ao valor mascada ordenados de forma ascendente e separados por ,. Ex:

queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]);
// '1.15,2.12,3.11'

*/













