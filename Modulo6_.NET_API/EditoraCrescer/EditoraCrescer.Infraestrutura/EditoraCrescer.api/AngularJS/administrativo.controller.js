
modulo.controller('AdministrativoController', function ($scope, editoraService, $routeParams, $location) {
    $scope.obterLivros = obterLivros;
    $scope.insereLivro = insereLivro;


    function insereLivro(livro){
        $scope.livro.IDRevisor=21;
        console.log($scope.livro);
        editoraService.criarLivro($scope.livro).then(response =>{

            console.log(response)
        });

    }


    function obterLivros() {
        editoraService
            .obterLivros()
            .then(response => {

            $scope.livros = response.data.data; 
            console.log($scope.livros);

        })
    }


});