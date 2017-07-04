modulo.factory("postagemService", function ($http) {
    return ({
        inserirPostagem:inserirPostagem,
        curtirPostagem:curtirPostagem,
        descurtirPostagem:descurtirPostagem
    });

    function inserirPostagem(postagem){
   
        return $http.post("http://localhost:9090/postagem", postagem);

    }
    
    
    function curtirPostagem(id){
   
        return $http.post("http://localhost:9090/curtir/" + id, {});

    }
    function descurtirPostagem(id){
        return $http.post("http://localhost:9090/descurtir/" + id, {});
    }

});