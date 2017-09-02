var value = 0;
var musica = document.getElementById("audioPokemon"); 
var nomePokemon = document.getElementById('nomePokemon');
var numeroPokemon = document.getElementById('numeroPokemon');
var imgPokemon = document.getElementById('img-pokemon');
var input = document.getElementById('inputIDPokemon');
var botao = document.getElementById('botaoEnvio');
var divPokemon = document.getElementById('divPokemon');
var tiposPokemon = document.getElementById('tiposPokemon');
var progressStat1 = document.getElementById('progressStat1');
var progressStat2 = document.getElementById('progressStat2');
var progressStat3 = document.getElementById('progressStat3');
var progressStat4 = document.getElementById('progressStat4');
var progressStat5 = document.getElementById('progressStat5');
var progressStat6 = document.getElementById('progressStat6');
botao.onclick = function(){fetch('https://pokeapi.co/api/v2/pokemon/'+input.value+'/').then(function(response) { 
    // Convert to JSON
    return response.json();
}).then(function(j) {
    botao.disabled=true;
    // Yay, `j` is a JavaScript object
    objJSON = j; 
    this.value=0;
    while (tiposPokemon.hasChildNodes()) {   
    tiposPokemon.removeChild(tiposPokemon.firstChild);
    }
    imgPokemon.src = j.sprites.front_default;
    imgPokemon.style.filter="brightness(0%)";
    nomePokemon.innerText = "Nome: " +  j.name;
    numeroPokemon.innerText = "Numero: " + j.id;
    divPokemon.style.visibility="visible";
    let stat1 = j.stats[0].base_stat;
    let stat2 = j.stats[1].base_stat;
    let stat3 = j.stats[2].base_stat;
    let stat4 = j.stats[3].base_stat;
    let stat5 = j.stats[4].base_stat;
    let stat6 = j.stats[5].base_stat;
    progressStat1.style.width = stat1/1.6 + '%'; progressStat1.innerText= stat1; mudarCorProgress(progressStat1, stat1);
    progressStat2.style.width = stat2/1.6 + '%'; progressStat2.innerText= stat2; mudarCorProgress(progressStat2, stat2);
    progressStat3.style.width = stat3/1.6 + '%'; progressStat3.innerText= stat3; mudarCorProgress(progressStat3, stat3);
    progressStat4.style.width = stat4/1.6 + '%'; progressStat4.innerText= stat4; mudarCorProgress(progressStat4, stat4);
    progressStat5.style.width = stat5/1.6 + '%'; progressStat5.innerText= stat5; mudarCorProgress(progressStat5, stat5);
    progressStat6.style.width = stat6/1.6 + '%'; progressStat6.innerText= stat6; mudarCorProgress(progressStat6, stat6);
    let tiposDoPokemon = j.types;
    for (tipos of tiposDoPokemon){

        var node = document.createElement("li");                 // Create a <li> node
        var textnode = document.createTextNode(tipos.type.name);  
        node.appendChild(textnode);
        tiposPokemon.appendChild(node);
    }
    

    
    musica.play();
    var thisInterval = setInterval(function changebrightness() {
        console.log(this.value);
        this.value += 4.7;
        if(this.value <=100) imgPokemon.setAttribute("style","-webkit-filter:brightness("+value+"%)");
        else {clearInterval(thisInterval);
             }
    },500);
});};

musica.onended = function(){
    botao.disabled=false;
}

function mudarCorProgress(divRecebida, stat){
    if(stat <=20) divRecebida.style.backgroundColor = 'black';
    else if(stat <50) divRecebida.style.backgroundColor = 'gray';
    else if (stat <80) divRecebida.style.backgroundColor = 'green';
    else if (stat <100) divRecebida.style.backgroundColor = 'blue';
    else divRecebida.style.backgroundColor = 'gold';
}

function hexToRgb(hex) {
    var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
    return result ? {
        r: parseInt(result[1], 16),
        g: parseInt(result[2], 16),
        b: parseInt(result[3], 16)
    } : null;
}

