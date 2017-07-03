modulo.factory("usuarioService", function ($http) {
    return ({
        getDados:getDados,
        getPostagensDosAmigos:getPostagensDosAmigos
    });

    function getDados(){
   
        return $http.get("http://localhost:9090/dadosUsuarioAtual");

    }
    
    function getPostagensDosAmigos(){
        
        return $http.get("http://localhost:9090/postagens/feed")
    }

});