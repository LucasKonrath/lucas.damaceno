
modulo.controller('AdministrativoController', function ($scope, editoraService,authService, $routeParams, $location) {
    $scope.obterLivros = obterLivros;
    $scope.insereLivro = insereLivro;
     $scope.auth = authService;

    function insereLivro(livro){
        $scope.livro.IDRevisor=21;
        console.log($scope.livro);
        editoraService.criarLivro($scope.livro).then(response =>{

            console.log(response)
        });

    }
    
    $scope.mensagem = {
    colaborador: 'Mensagem incrível para o usuário AUTENTICADO',
    editor: 'Mensagem incrível para o usuário EDITOR',
  };
    
    
    
     $scope.logout = function (usuario) {

    authService.logout(usuario);

  };


    function obterLivros() {
        editoraService
            .obterLivros()
            .then(response => {

            $scope.livros = response.data.data; 
            console.log($scope.livros);

        })
    }


});