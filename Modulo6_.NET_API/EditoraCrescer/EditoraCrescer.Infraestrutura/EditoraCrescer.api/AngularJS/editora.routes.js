var modulo = angular.module('editoraApp', ['ui.bootstrap', 'ngRoute', 'auth']);
modulo.config(function ($routeProvider) {

    $routeProvider
        .when('/login', {
        controller: 'EditoraController',
        templateUrl: 'Login.html',
        css: 'login.css'
    })
        .when('/editora', {
        controller: 'EditoraController',
        templateUrl: 'Editora.html'
    }).when('/livro/:idLivro', {
        controller: 'LivroDetalhadoController',
        templateUrl: 'detalheLivro.html'
    })
        .otherwise({redirectTo: 'index.html'});
});

modulo.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:63773/api/usuario',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/administrativo',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/editora'
});