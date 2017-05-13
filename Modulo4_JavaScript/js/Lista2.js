/*

Exercício 1

Séries Inválidas

Nesse exercício deverá ser implementada uma função chamada seriesInvalidas(series) que recebe o array de séries, verifica quais são as séries inválidas e retorna o título das séries inválidas em formato String.

Exemplo:

seriesInvalidas(series); // retorna "Séries Inválidas: Série 1 - Série 2 ..."
Condições para as séries serem inválidas:

Ano de estreia maior que o ano atual;
Possuir algum campo que seja undefined ou nullo.

*/

function seriesInvalidas(seriesRecebidas){
    var seriesInvalidas = new Array();
    var dataAtual = new Date();
    var anoAtual = dataAtual.getFullYear();
    for(var series of seriesRecebidas){
        var valores = Object.values(series);

        for(let valor of valores){
            var valorJaRetornado = false;
            if(valor === null || typeof valor === "undefined") {
                seriesInvalidas.push(series);
                console.log(valor + "palmito");
                valorJaRetornado=true;
            }
        }
        if(series.anoEstreia > anoAtual && valorJaRetornado===false) seriesInvalidas.push(series);
    }
    var titulos = new Array();
    for(series of seriesInvalidas){
        titulos.push(series.titulo);
    }
    return "Séries Inválidas:" + titulos.join(" - ");
}



/*
Séries a partir de um determinado ano

Nesse exercício deverá ser implementada uma função chamada filtrarSeriesPorAno(series, ano) que recebe o array de séries e devolve um outro array contendo apenas as séries com ano maior ou igual ao ano passado por parâmetro.

*/

function filtrarSeriesPorAno(series, ano){
    var seriesMaisNovas = new Array();
    for(serie of series){
        if(serie.anoEstreia >= ano) seriesMaisNovas.push(serie);
    }
    return seriesMaisNovas;
}




/*

Exercício 3

Média de Episódios

Crie uma função chamada mediaDeEpisodios(series) que recebe o array de séres e retorna a média dos episódios de todas as séries contidas no array.

Exemplo:

*/

function mediaDeEpisodios(series){
    var numeroSeries = series.length;
    var totalEpisodios = 0;
    for(let serie of series){
        if(typeof serie.numeroEpisodios !== "undefined") totalEpisodios += serie.numeroEpisodios;
    }
    return totalEpisodios / numeroSeries;
}


/*

    Exercício 4

Eu sou um ator de séries?

Crie uma função chamada procurarPorNome(series, nome) que recebe um array de séries e um nome e caso esse nome possua no elenco das séries, retorna true.

*/

function procurarPorNome(series,nome){
    var temNome = false;
    for(serie of series){

        for(nomes of serie.elenco){

            if(nome === nomes){ 
                temNome = true; 
                break;
            }

        }

    }
    return temNome;

}

/*

Exercicio 5

Mascada em Serie

Uma serie tem seu elenco e diretor(es), mas para ela acontecer, eles devem ser pagos. Crie uma função chamada mascadaEmSerie que retornará o valor total do salário a ser pago por mês para determinada serie. Para isso, suponha que os Big-Bosses, os Diretores, ganhem R$ 100.000; Enquanto os operarios os peões o pessoal do elenco ganha R$ 40.000;

*/

function mascadaEmSerie(serie){
    var valorTotal = 0;
    var numeroDiretores = serie.diretor.length;
    var tamanhoElenco = serie.elenco.length;
    if(numeroDiretores) valorTotal += (numeroDiretores * 100.000);
    if(tamanhoElenco) valorTotal += (tamanhoElenco * 40.000);
    return valorTotal;
}

/*
Exercicio 6

Buscas!

A - Não sei o que quero assitir, mas quero ver CAOS! Escreva uma função chamada queroGenero que retorne um array, com os títulos dos filmes que são correspondentes com o genero do parâmetro.

*/

function queroGenero(genero){
    var arrayTitulos = new Array();
    for(serie of series){
        for(generos of serie.genero){
            if(genero == generos){
                arrayTitulos.push(serie.titulo);
            }
        }
    }
  return arrayTitulos; 
}

/*

B - Sei exatamente o que quero assistir! Escreva uma função chamada queroTitulo que retorne um array, com os títulos dos filmes que tem título semelhante ao passado


*/

function queroTitulo(tituloRecebido){
    var arrayTitulos = new Array();
    for(serie of series){
        if((serie.titulo.toLowerCase()).includes(tituloRecebido.toLowerCase())) arrayTitulos.push(serie.titulo);
    }
    return arrayTitulos;
}


/*


Exercicio 7

Creditos

Ao final de um episódio, temos os créditos do episódio. Para isso vamos implementar uma função, chamada de creditosIlluminatis Recebendo uma serie como parâmetro e imprima os créditos a partir dela. Deverá ser impresso, o Titulo da serie, os Diretores, avisando com um título que é o bloco deles; Em seguida vem o elenco, também com um título de Elenco;

Tranquilo né? Easy! MAS, tem o seguinte: Os créditos são sempre ordenados alfabéticamente, mas pelo ULTIMO NOME!! Faça os ajustes necessários para que isso seja possível

Consulte as interwebsss para ajudar


*/

function creditosIlluminatis(serie){
    console.log("Título da serie: " +  serie.titulo );
    var ArrayElenco = new Array();
    var ArrayElencoInvertido = new Array();
    var ArrayDiretores = new Array();
    var ArrayDiretoresInvertido = new Array();
        for(diretores of serie.diretor){
            ArrayDiretores.push(diretores);
        }
        for(membrosElenco of serie.elenco){
            ArrayElenco.push(membrosElenco);
        }
        function inverter(arrayAInverter,arrayAArmazenar){
            arrayAArmazenar = [];
        for(let i = 0; i < arrayAInverter.length;i++){
            var sobrenome = arrayAInverter[i].split(" ")[1];
            var primeiroNome = arrayAInverter[i].split(" ")[0];
            arrayAArmazenar.push(sobrenome + " " + primeiroNome);
        }
            return arrayAArmazenar;
        }
        console.log("Diretores da série : ");
         console.log((inverter(inverter(ArrayDiretores, ArrayDiretoresInvertido).sort(), ArrayDiretores)).join("\n") );
         console.log("Elenco da série : ");
         console.log((inverter(inverter(ArrayElenco, ArrayElencoInvertido).sort(), ArrayElenco)).join("\n") );
        
}









//