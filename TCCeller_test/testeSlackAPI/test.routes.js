var modulo = angular.module('testApp', ['ngRoute']);


modulo.config(function ($routeProvider, $httpProvider, $httpParamSerializerProvider ) {

    var paramSerializer = $httpParamSerializerProvider.$get();
        console.log('testing serializer', paramSerializer({a:1, b:2}));
    
    $routeProvider
        .when('/test', {
        controller: 'TesteController',
        templateUrl: 'index.html'
    })
     .otherwise({redirectTo: '/test'});
});