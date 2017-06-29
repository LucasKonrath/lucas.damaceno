var modulo = angular.module('comixZoneApp', [ 'ngRoute', 'auth','ngStorage']);
modulo.config(function ($routeProvider) {

    $routeProvider
        .when('/login', {
        controller: 'LoginController',
        templateUrl: 'Login.html',
        css: 'login.css'
    }).otherwise({redirectTo: '/login2'});
});

modulo.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:9090/api/Usuario',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/login2',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/login'
});