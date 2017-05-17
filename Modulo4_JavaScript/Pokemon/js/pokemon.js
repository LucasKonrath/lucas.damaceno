var value = 0;
var musica = document.getElementById("audioPokemon"); 
var nomePokemon = document.getElementById('nomePokemon');
var numeroPokemon = document.getElementById('numeroPokemon');
var imgPokemon = document.getElementById('img-pokemon');
var input = document.getElementById('inputIDPokemon');
var botao = document.getElementById('botaoEnvio');
var divPokemon = document.getElementById('divPokemon')
botao.onclick = function(){fetch('https://pokeapi.co/api/v2/pokemon/'+input.value+'/').then(function(response) { 
    // Convert to JSON
    return response.json();
}).then(function(j) {
    // Yay, `j` is a JavaScript object
    objJSON = j; 
    this.value=0;
    imgPokemon.src = j.sprites.front_default;
    imgPokemon.style.filter="brightness(0%)";
    nomePokemon.innerText = "Nome: " +  j.name;
    numeroPokemon.innerText = "Numero: " + j.id;
    divPokemon.style.visibility="visible";
    musica.play();
    var thisInterval = setInterval(function changebrightness() {
    console.log(this.value);
    this.value += 2;
   if(this.value <=100) imgPokemon.setAttribute("style","-webkit-filter:brightness("+value+"%)");
    else clearInterval(thisInterval);
},500);
});};

