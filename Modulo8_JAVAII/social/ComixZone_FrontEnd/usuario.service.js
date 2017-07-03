modulo.factory("usuarioService", function ($http) {
    return ({
        getDados:getDados,
        getPostagensDosAmigos:getPostagensDosAmigos,
        getDadosEspecificos:getDadosEspecificos,
        getPostagensEspecificas:getPostagensEspecificas,
        getSolicitacoes:getSolicitacoes
    });

    function getDados(){
   
        return $http.get("http://localhost:9090/dadosUsuarioAtual");

    }
    
    function getPostagensDosAmigos(){
        
        return $http.get("http://localhost:9090/postagens/feed");
    }
    
    function getDadosEspecificos(id){
        return $http.get("http://localhost:9090/usuario/" + id + "");
    }
    
    function getPostagensEspecificas(id){
        return $http.get("http://localhost:9090/postagens/" + id + "");
    }
    
    function getSolicitacoes(){
        return $http.get("http://localhost:9090/usuario/solicitacoes");
    }

});