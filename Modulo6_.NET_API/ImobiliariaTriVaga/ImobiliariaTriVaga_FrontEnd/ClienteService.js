modulo.factory("clienteService", function ($http) {
    return ({
        obterClientePorCPF: obterClientePorCPF,
        
        
    });

    function obterClientePorCPF(cpf) {
        return $http.get('http://localhost:55508/api/cliente/CPF?CPF=' + cpf + '');
    }

    
});