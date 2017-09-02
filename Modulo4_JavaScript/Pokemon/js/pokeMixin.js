var value = 0;
var img1loaded = false;
var img2loaded=false;
var img3loaded=false;
var campoCor = document.getElementById('color');
var musica = document.getElementById("audioPokemon"); 
var imgPokemon = document.getElementById('img-pokemon1');
var imgPokemon2 = document.getElementById('img-pokemon2');
var imgPokemon3 = document.getElementById('img-pokemon3');
var botao = document.getElementById('botaoEnvioCor');
var divPokemon = document.getElementById('pokeMixinDiv');
botao.onclick = function(){
    
    var valores = hexToRgb(campoCor.value);
    console.log(valores.r);
    console.log(valores.g);
    console.log(valores.b);
    divPokemon.style.backgroundColor=campoCor.value;
    
    
    
    {fetch('https://pokeapi.co/api/v2/pokemon/'+valores.r+'/').then(function(response) { 
    // Convert to JSON
    return response.json();
}).then(function(j) {
    botao.disabled=true;
    // Yay, `j` is a JavaScript object
    objJSON = j; 
    this.value=0;
    imgPokemon.src = j.sprites.front_default;
    imgPokemon.style.filter="brightness(0%)";  
    musica.play();
    this.img1loaded=true;
    var thisInterval = setInterval(function changebrightness() {
        console.log(this.value);
        this.value += 4.7;
        if(this.value <=100) imgPokemon.setAttribute("style","-webkit-filter:brightness("+value+"%)");
        else {clearInterval(thisInterval);
             }
    },500);
});}   
    
{fetch('https://pokeapi.co/api/v2/pokemon/'+valores.g+'/').then(function(response) { 
    // Convert to JSON
    return response.json();
}).then(function(j) {
    botao.disabled=true;
    // Yay, `j` is a JavaScript object
    objJSON = j; 
    this.value=0;
    imgPokemon2.src = j.sprites.front_default;
    imgPokemon2.style.filter="brightness(0%)";
    this.img2loaded=true;
    var thisInterval = setInterval(function changebrightness() {
        console.log(this.value);
        this.value += 4.7;
        if(this.value <=100) imgPokemon2.setAttribute("style","-webkit-filter:brightness("+value+"%)");
        else {clearInterval(thisInterval);
             }
    },500);
});}
    
    {fetch('https://pokeapi.co/api/v2/pokemon/'+valores.b+'/').then(function(response) { 
    // Convert to JSON
    return response.json();
}).then(function(j) {
    botao.disabled=true;
    // Yay, `j` is a JavaScript object
    objJSON = j; 
    this.value=0;
    imgPokemon3.src = j.sprites.front_default;
    imgPokemon3.style.filter="brightness(0%)";  
        this.img3loaded=true;
    var thisInterval = setInterval(function changebrightness() {
        console.log(this.value);
        this.value += 4.7;
        if(this.value <=100) imgPokemon3.setAttribute("style","-webkit-filter:brightness("+value+"%)");
        else {clearInterval(thisInterval);
             }
    },500);
});}
 divPokemon.style.visibility="visible";
//fim do Onclick
}
    
    
    
    
    
   

musica.onended = function(){
    botao.disabled=false;
}

function mudarCorProgress(divRecebida, stat){
    if(stat <= 20) divRecebida.style.backgroundColor = 'gray';
    else if(stat <50) divRecebida.style.backgroundColor = 'yellow';
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

