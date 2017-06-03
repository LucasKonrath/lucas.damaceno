
modulo.controller('LivroDetalhadoController', function ($scope, editoraService, $routeParams, $location) {
 
var idLivro = $routeParams.idLivro;
$scope.idExibir = idLivro;

    
    editoraService.obterLivroPorID(idLivro).then(response => {

            $scope.livro = response.data.data; 
            console.log($scope.livro);

        })
    
});