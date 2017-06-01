var modulo = angular.module('editoraApp', []);

modulo.controller('EditoraController', function ($scope, editoraService) {
 
    
    $scope.carregarLivros = carregarLivros;
    $scope.obterLivros = obterLivros;
    $scope.proximaPagina = proximaPagina;
    $scope.obterLancamentos = obterLancamentos;
    
    
    function proximaPagina(){
    
    }
    function obterLivros() {
        editoraService
        .obterLivros()
        .then(response => {
            
            $scope.livros = response.data.data; 
            console.log($scope.livros);
            
        })
    }
    
    function obterLancamentos() {
        editoraService
        .obterLancamentos()
        .then(response => {
            
            $scope.lancamentos = response.data.data; 
            console.log($scope.lancamentos);
            
        })
    }
    
    function carregarLivros(){
        
        obterLancamentos();
        obterLivros();
        
    }
    
    
});