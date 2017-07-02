modulo.factory("cadastroService", function ($http) {
    return ({
        cadastrarUsuario:cadastrarUsuario
        
    });

    function cadastrarUsuario(usuario){
   
        return $http.post("http://localhost:9090/usuario", usuario);

    }

});