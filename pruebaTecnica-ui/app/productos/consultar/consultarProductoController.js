'use strict';

angular
    .module('pruebaTecnicaApp')
    .controller(
        'ConsultarProductoController',
        [
            '$scope',
            '$filter',
            '$cookies',
            'apiClient',
            'endpoints',
            'utils',
            'AlertService',
            'pathsFactory',
            function($scope, $filter, $cookies, apiClient,
                endpoints, utils, AlertService, pathsFactory) {
                AlertService.clear();
                $scope.productosFiltrados = [];

                $scope.filtro = {
                    referenciaProducto: ""
                };
                $scope.alertas = AlertService.get();

                $scope.paging = {
                    page: 1,
                    limit: 10,
                    items: $scope.productosFiltrados.length,
                    total: $scope.productosFiltrados.length,
                    pages: Math.ceil($scope.items / $scope.limit),
                    maxSize: 5
                };

                // Proceso de Paginación
                $scope.setPage = function(page) {
                    $scope.paging.page = page;
                };

                $scope
                    .$watch(
                        function(scope) {
                            return scope.productosFiltrados.length;
                        },
                        function(newValue, oldValue) {
                            $scope.paging.items = $scope.productosFiltrados.length;
                            $scope.paging.total = $scope.productosFiltrados.length;
                        });


                $scope.buscarReferencia = function() {

                    if ($scope.filtro.referenciaProducto !== undefined &&
                        $scope.filtro.referenciaProducto !== "") {

                        var resultadoRegistro = apiClient
                            .doGet(
                                pathsFactory
                                .generatePath(endpoints.CONSULTAR_PRODUCTO_REFERENCIA) + '/' + $scope.filtro.referenciaProducto,
                                $cookies
                                .getObject(utils.PRUEBATECNICA_COOKIE).token);
                        resultadoRegistro
                            .then(
                                function(response) {

                                    $scope.productosFiltrados = [];

                                    if (response.data != "") {
                                        $scope.productosFiltrados.push(response.data);
                                    }

                                    AlertService
                                        .success("Búsqueda Realizada Correctamente");
                                },
                                function(error) {
                                    AlertService
                                        .error("Ocurrio un error consultando el producto por la referencia");
                                });

                    } else {
                        AlertService
                            .warning("Los campos son obligatorios");
                    }
                };

                $scope.buscarTodos = function() {

                    var resultadoRegistro = apiClient
                        .doGet(
                            pathsFactory
                            .generatePath(endpoints.CONSULTAR_TODOS_PRODUCTOS),
                            $cookies
                            .getObject(utils.PRUEBATECNICA_COOKIE).token);
                    resultadoRegistro
                        .then(
                            function(response) {

                                $scope.productosFiltrados = response.data;

                                AlertService
                                    .success("Búsqueda Realizada Correctamente");
                            },
                            function(error) {
                                AlertService
                                    .error("Ocurrio un error consultando los productos");
                            });
                };

            }

        ]);