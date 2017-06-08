modulo.factory("clienteService", function ($http) {
    return ({
        obterClientePorCPF: obterClientePorCPF,
        cadastrarCliente: cadastrarCliente
        
    });

    function obterClientePorCPF(cpf) {
        return $http.get('http://localhost:55508/api/cliente/CPF?CPF=' + cpf + '');
    }
    
    function cadastrarCliente(cliente){
        
        return $http.post('http://localhost:55508/api/cliente/criar',cliente);
        
    }

    
});