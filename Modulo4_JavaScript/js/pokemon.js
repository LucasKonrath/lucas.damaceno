let urls = [
  "http://pokeapi.co/api/v2/pokemon/66/",
  "http://pokeapi.co/api/v2/pokemon/68/",
  "http://pokeapi.co/api/v2/pokemon/76/"
]
urls.forEach(url => {
  fetch(url)
    .then(response => response.json())
    .then(json => {
      console.log(json);
      console.log(json.sprites.front_default);
      let div = document.getElementById('detalhesPokemon');
      let img = document.createElement('img');
      img.src = json.sprites.front_default;
      div.append(img);
    })
})


console.log("Linha 8")