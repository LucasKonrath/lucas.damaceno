var modulo = angular.module('comixZoneApp', [ 'ngRoute', 'auth','ngStorage']);
modulo.config(function ($routeProvider) {

    $routeProvider
        .when('/login', {
        controller: 'LoginController',
        templateUrl: 'Login.html',
        css: 'login.css'
    }).when('/cadastro', {
         controller: 'CadastroController',
        templateUrl: 'cadastro.html',
        css: 'cadastro.css'
    })
    .when('/feed', {
         controller: 'FeedController',
        templateUrl: 'feed.html',
        css: 'feed.css'
    })
     .otherwise({redirectTo: '/login'});
});

modulo.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:9090/usuarioAtual',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/feed',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/login'
});