modulo.factory("editoraService", function ($http) {
    return ({
        obterLivros: obterLivros,
        obterLancamentos: obterLancamentos,
        obterLivrosParametros: obterLivrosParametros
    });

    function obterLivros() {
        return $http.get("http://localhost:63773/api/Livros");
    }
    
    function obterLivrosParametros(pegar, pular) {
        return $http.get('http://localhost:63773/api/Livros/' + pegar + '/' + pular +'');
    }
    
    
    function obterLancamentos() {
        return $http.get("http://localhost:63773/api/Livros/Lancamentos");
    }

   
});