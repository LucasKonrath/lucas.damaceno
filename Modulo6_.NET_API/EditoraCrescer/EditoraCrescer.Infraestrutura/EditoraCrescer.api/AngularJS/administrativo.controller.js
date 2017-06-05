
modulo.controller('AdministrativoController', function ($scope, editoraService,authService, $routeParams, $location) {
    $scope.obterLivrosCompletos = obterLivrosCompletos;
    $scope.insereLivro = insereLivro;
    $scope.auth = authService;
    $scope.remover = remover;
    $scope.revisarLivro = revisarLivro;
    $scope.publicarLivro = publicarLivro;
 
    
    function insereLivro(livro){
        console.log(livro);
        editoraService.criarLivro(livro).then(response =>{
            obterLivrosCompletos();
            console.log(response);
        });

    }

    function remover(isbn){

        editoraService.removerLivro(isbn).then(
            response => {
                obterLivrosCompletos(); 
                console.log(response);

            });

    }
    
    function revisarLivro(isbn){
        editoraService.revisarLivro(isbn).then(
        response =>
            {
                obterLivrosCompletos();
                console.log(response);
            }
        )     
    }

    
    function publicarLivro(isbn){
        editoraService.publicarLivro(isbn).then(
        response =>
            {
                $scope.obterLivrosCompletos();
            }
        )     
    }

    $scope.logout = function (usuario) {

        authService.logout(usuario);

    };


    function obterLivrosCompletos() {
        editoraService
            .obterLivrosCompletos()
            .then(response => {

            $scope.livros = response.data.data; 
            console.log($scope.livros);

        })
    }


});