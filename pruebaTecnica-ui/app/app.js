'use strict';

// Declare app level module which depends on views, and components
var app = angular.module('pruebaTecnicaApp', ['ngSanitize', 'ngCookies',
    'ng.httpLoader', 'base64', 'angularjs-autocomplete', 'ui.router',
    'ui.bootstrap', 'ui.bootstrap.tpls', 'pruebaTecnicaApp.version',
    'pruebaTecnicaApp.services', 'pruebaTecnicaApp.constants.endpoints',
    'pruebaTecnicaApp.constants.utils', 'pruebaTecnicaApp.factories.generators'
]);

app.config([
    'httpMethodInterceptorProvider',
    function(httpMethodInterceptorProvider) {
        httpMethodInterceptorProvider.whitelistLocalRequests();
        httpMethodInterceptorProvider
            .whitelistDomain('http://localhost:8080');
    }
]);

app
    .config(function($stateProvider, $urlRouterProvider, $locationProvider,
        $httpProvider) {
        $urlRouterProvider.otherwise("/login");
        $httpProvider.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
        $stateProvider
            .state('login', {
                url: '/login',
                templateUrl: 'login/login.html',
                controller: 'LoginCtrl as loginCtrl'
            })
            .state('app', {
                url: '/app',
                templateUrl: 'home/home.html',
                controller: 'HomeCtrl as homeCtrl'
            })
            .state('app.home', {
                url: '/home',
                views: {
                    'header@app': {
                        templateUrl: 'home/header/header.html',
                        controller: 'HeaderCtrl'
                    },
                    'menu@app': {
                        templateUrl: 'home/menu/menu.html',
                        controller: 'menuCtrl'
                    }
                }
            })
            .state('app.home.registrar-producto', {
                url: '/registrar_productos',
                views: {
                    'content@app': {
                        templateUrl: 'productos/registrar/registrarProducto.html',
                        controller: 'RegistrarProductoController as registrarProductoCtrl'
                    }
                }
            })
            .state('app.home.consultar-producto', {
                url: '/consultar_productos',
                views: {
                    'content@app': {
                        templateUrl: 'productos/consultar/consultarProducto.html',
                        controller: 'ConsultarProductoController as consultarProductoCtrl'
                    }
                }
            })
            .state('app.home.movimiento-producto', {
                url: '/registrar_movimiento',
                views: {
                    'content@app': {
                        templateUrl: 'movimientoProductos/registrar/registrarMovimiento.html',
                        controller: 'RegistrarMovimientoController as registrarMovimientoCtrl'
                    }
                }
            })
            .state('app.home.consultar-movimiento', {
                url: '/consultar_movimiento',
                views: {
                    'content@app': {
                        templateUrl: 'movimientoProductos/consultar/consultarMovimientos.html',
                        controller: 'ConsultarMovimientosController as consultarMovimientoCtrl'
                    }
                }
            })
    });

app
    .run(function($rootScope, $templateCache, $state, $filter, $cookies,
        AlertService) {
        $rootScope
            .$on(
                '$stateChangeStart',
                function(event, toState, toParams, fromState,
                    fromParams) {

                    $templateCache.remove(toState.templateUrl);

                    var autenticationData = $cookies
                        .getObject('pruebaTecnica-web');
                    if (toState.name !== "login") {
                        if (fromState.url === "^" &&
                            (autenticationData === undefined || autenticationData.token === null)) {
                            event.preventDefault();
                        } else {
                            AlertService.clear();
                        }
                    }

                });
    });