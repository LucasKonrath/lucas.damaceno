modulo.factory("imovelService", function ($http) {
    return ({
        obterImoveis: obterImoveis,
        obterTamanhos: obterTamanhos,
        obterAdicionais: obterAdicionais,
        gerarPedido: gerarPedido,
        obterPedido: obterPedido,
        excluirPedido: excluirPedido,
        devolverPedido: devolverPedido,
        obterPedidos: obterPedidos,
        retornarPedido: retornarPedido,
        obterRelatorioAtraso: obterRelatorioAtraso,
        obterRelatorioGerencia: obterRelatorioGerencia

    });

    function obterImoveis() {
        return $http.get('http://localhost:55508/api/tipoImovel/obterImoveis');
    }

    function obterTamanhos(id){

        return  $http.get('http://localhost:55508/api/tipoImovel/obterTamanhosDoImovel/'+ id +'');
    }
    function obterAdicionais(){

        return $http.get('http://localhost:55508/api/adicionais');

    }

    function gerarPedido(pedido){

        return $http.post('http://localhost:55508/api/pedidos/criar',pedido);

    }
    
    function obterRelatorioGerencia(data){
        console.log(data.toLocaleDateString());
        return $http.get('http://localhost:55508/api/pedidos/obterfinalizados/' + data.toLocaleDateString() +'');
    }

    function obterPedido(id){

        return $http.get('http://localhost:55508/api/pedidos/obter/'+id);
    }
    
    function retornarPedido(id){

        return $http.delete('http://localhost:55508/api/pedidos/retornar/'+id);
    }
    
    function excluirPedido(id){
        
        return $http.delete('http://localhost:55508/api/pedidos/deletar/' + id);
    }
    
    function obterRelatorioAtraso(){
        return $http.get('http://localhost:55508/api/pedidos/obteratrasos/');
    }
    
    function devolverPedido(id){
        return $http.delete('http://localhost:55508/api/pedidos/retornar/' + id);
    }
    
    function obterPedidos(){

        return $http.get('http://localhost:55508/api/pedidos/obtertodos');
    }
});