var modulo = angular.module('editoraApp', ['ui.bootstrap', 'ngRoute']);
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