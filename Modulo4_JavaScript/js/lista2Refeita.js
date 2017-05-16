*/
Exercício 1

Séries Inválidas

Nesse exercício deverá ser implementada uma função chamada seriesInvalidas(series) que recebe o array de séries, verifica quais são as séries inválidas e retorna o título das séries inválidas em formato String.

Exemplo:

seriesInvalidas(series); // retorna "Séries Inválidas: Série 1 - Série 2 ..."
Condições para as séries serem inválidas:

Ano de estreia maior que o ano atual;
Possuir algum campo que seja undefined ou nullo.

*/

function seriesInvalidas(series){

let invalidas = series.filter( serie => {

	let algumCampoInvalido = Object.values(serie).some(v => v === null || typeof v === 'undefined');
	let estreiaInvalida = serie.anoEstreia > new Date().getFullYear();
	return estreiaInvalida || algumCampoInvalido;

});
	return "Séries Inválidas: " + invalidas.map( p => p.titulo).join(" - ");
}

/*
Séries a partir de um determinado ano

Nesse exercício deverá ser implementada uma função chamada filtrarSeriesPorAno(series, ano) que recebe o array de séries e devolve um outro array contendo apenas as séries com ano maior ou igual ao ano passado por parâmetro.

*/

function filtrarSeriesPorAno(series, ano){

	return series.filter(s => s.anoEstreia >= ano);
}


/*

Exercício 3

Média de Episódios

Crie uma função chamada mediaDeEpisodios(series) que recebe o array de séres e retorna a média dos episódios de todas as séries contidas no array.

Exemplo:

*/

function mediaDeEpisodios(series){

	return series.map(s => s.numeroEpisodios).reduce(function(a,b){ return a+b;} )/series.length;
}

 */   Exercício 4

Eu sou um ator de séries?

Crie uma função chamada procurarPorNome(series, nome) que recebe um array de séries e um nome e caso esse nome possua no elenco das séries, retorna true.

*/

function procurarPorNome(series,nome){

	return series.map(s=> s.elenco).filter( x => x.includes(nome)).length > 0;

}

/*

Exercicio 5

Mascada em Serie

Uma serie tem seu elenco e diretor(es), mas para ela acontecer, eles devem ser pagos. Crie uma função chamada mascadaEmSerie que retornará o valor total do salário a ser pago por mês para determinada serie. Para isso, suponha que os Big-Bosses, os Diretores, ganhem R$ 100.000; Enquanto os operarios os peões o pessoal do elenco ganha R$ 40.000;

*/

function mascadaEmSerie(serie){

	return serie.elenco.length * 40000 + serie.diretor.length * 100000;

}

/*
Exercicio 6

Buscas!

A - Não sei o que quero assitir, mas quero ver CAOS! Escreva uma função chamada queroGenero que retorne um array, com os títulos dos filmes que são correspondentes com o genero do parâmetro.

*/

function queroGenero(genero){

   return  series.filter( s=> s.genero.includes(genero));	
}

