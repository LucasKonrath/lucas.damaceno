modulo.factory("postagemService", function ($http) {
    return ({
        inserirPostagem:inserirPostagem
    });

    function inserirPostagem(postagem){
   
        return $http.post("http://localhost:9090/postagem", postagem);

    }

});