modulo.controller('LoginController', function ($scope, authService, $routeParams, $location) {
  
  $scope.login = function (usuario) {

    authService.login($scope.usuario)
      .then(
        function (response) {
          console.log(response);
          alert('Login com sucesso!');

        },
        function (response) {
          console.log(response);
          alert('Erro no Login!');
        });
  };

});