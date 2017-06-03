var modulo = angular.module('editoraApp', ['ui.bootstrap']);

modulo.controller('EditoraController', function ($scope, editoraService) {

    $scope.myInterval = 3000;
    $scope.carregarLivros = carregarLivros;
    $scope.obterLivros = obterLivros;
    $scope.proximaPagina = proximaPagina;
    $scope.obterLancamentos = obterLancamentos;
    $scope.mostrarModal = false;
    $scope.controlePaginas = 0;
    $scope.proximaPagina = proximaPagina;
    $scope.paginaAnterior = paginaAnterior;
    $scope.obterLivrosMenu = obterLivrosMenu;
    
    
    function proximaPagina(){

        $scope.controlePaginas += 1;
        obterLivrosMenu(3, $scope.controlePaginas * 3);
    }

    function paginaAnterior(){

        $scope.controlePaginas -= 1;
        if($scope.controlePaginas < 0) $scope.controlePaginas = 0;
        obterLivrosMenu(3, $scope.controlePaginas*3);
    }







    function obterLivros() {
        editoraService
            .obterLivros()
            .then(response => {

            $scope.livros = response.data.data; 
            console.log($scope.livros);

        })
    }


    function obterLivrosMenu(pegar, pular) {
        editoraService
            .obterLivrosParametros(pegar, pular)
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
        obterLivrosMenu(3, 0);

    }


});