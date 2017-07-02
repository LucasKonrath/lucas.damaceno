modulo.controller('CadastroController', function ($scope, cadastroService, authService, $routeParams, $location) {

    $scope.cadastrar = cadastrar;

    function login (usuario) {

        authService.login(usuario)
            .then(
            function (response) {
                console.log(response);
                swal("Feito!", "Login com sucesso!", "success");

            },
            function (response) {
                console.log(response);
                swal("Eita!", "Usuário ou Senha inválidos!", "error");
            });
    };


    function cadastrar(usuario){
        console.log(usuario);
        cadastroService.cadastrarUsuario(usuario).then(response => {
            
            console.log(response);
            login(usuario);

        })

    }

});