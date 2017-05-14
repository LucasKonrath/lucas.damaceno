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
    var seriesInvalidas = [];
    var dataAtual = new Date();
    var anoAtual = dataAtual.getFullYear();
    for(var series of seriesRecebidas){
        var valores = Object.values(series);

        for(let valor of valores){
            var valorJaRetornado = false;
            if(valor === null || typeof valor === "undefined") {
                seriesInvalidas.push(series);
                valorJaRetornado=true;
            }
        }
        if(series.anoEstreia > anoAtual && valorJaRetornado===false) seriesInvalidas.push(series);
    }
    var titulos = [];
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
    var seriesMaisNovas = [];
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
    var totalEpisodios = 0;
    for(let serie of series){
        if(typeof serie.numeroEpisodios !== "undefined") totalEpisodios += serie.numeroEpisodios;
    }
    return totalEpisodios / series.length;
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
    if(serie.diretor.length) valorTotal += (serie.diretor.length * 100000);
    if(serie.elenco.length) valorTotal += (serie.elenco.length * 40000);
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
            if(genero.toLowerCase() === generos.toLowerCase()) {
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
    var arrayTitulos = [];
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
    function inverter(arrayAInverter){
        arrayInvertido = [];
        for(let i = 0; i < arrayAInverter.length;i++){
            var sobrenome = arrayAInverter[i].split(" ")[1];
            var primeiroNome = arrayAInverter[i].split(" ")[0];
            arrayInvertido.push(sobrenome + " " + primeiroNome);
        }
        return arrayInvertido;
    }
    function ordenarEImprimir(ArrayOriginal){
    	console.log((inverter(inverter(ArrayOriginal).sort()).join("\n"))) ;
    }
    console.log("Diretores da série : ");
    ordenarEImprimir(serie.diretor);
    console.log("Elenco da série : ");
    ordenarEImprimir(serie.elenco);
}


/*

        Serie Illuminati

Escondemos um pequeno easter egg neste exercicio!

Para que ele seja descoberto, será necessário algumas informações;

Quando abreviamos um nome colocamos a primeira letra do nome seguida de um ponto final Exemplo:

Bernardo Bosak Rezende -> Bernardo B. Rezende
Augusto Schiller Wartchow -> Augusto S. Wartchow
Essa é a informação básica; Construa uma função que identificará aquela série que tem TODOS do elenco com nomes abreviados.

Dica: Contrua uma função separada para identificar se aquela string tem a abreviação;

Show de bola, estamos quase lá!

Uma vez achada a serie, vamos modificar um pouquinho a implementação. Coloque todas as palavras abreviadas (de preferência sem os pontos finais) em uma string que será retornada ao final do método.

Forme uma hashtag com a palavra! #PALAVRA


*/
/*
function temPonto(element){

	return element.contains(".");

}

series.elenco.every(temponto);

*/
function temPonto(element){

	return element.includes(".");

}

function qualSerieEIlluminati(){
	    var stringASerRetornada = "#";
    for(let i = 0; i<series.length;i++){
        if (series[i].elenco.every(temPonto) === true) {
        	 for(membroElenco of series[i].elenco){
                        stringASerRetornada += membroElenco.split(" ")[1];
                        stringASerRetornada = stringASerRetornada.split('.').join('');
                    }
        } 
    }
    return stringASerRetornada;
}






//