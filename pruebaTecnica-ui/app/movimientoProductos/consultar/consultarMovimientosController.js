'use strict';

angular
    .module('pruebaTecnicaApp')
    .controller(
        'ConsultarMovimientosController',
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
                $scope.movimientosFiltrados = [];
                $scope.filtro = {
                    referenciaProducto: ""
                };

                $scope.producto = {
                    descripcion: "",
                    cantidadDisponible: ""
                };
                $scope.alertas = AlertService.get();

                $scope.paging = {
                    page: 1,
                    limit: 10,
                    items: $scope.movimientosFiltrados.length,
                    total: $scope.movimientosFiltrados.length,
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
                            return scope.movimientosFiltrados.length;
                        },
                        function(newValue, oldValue) {
                            $scope.paging.items = $scope.movimientosFiltrados.length;
                            $scope.paging.total = $scope.movimientosFiltrados.length;
                        });

                $scope.buscarMovimientosReferencia = function() {

                    if ($scope.filtro.referenciaProducto !== undefined &&
                        $scope.filtro.referenciaProducto !== "") {

                        var resultadoRegistro = apiClient
                            .doGet(
                                pathsFactory
                                .generatePath(endpoints.CONSULTAR_MOVIMIENTO_PRODUCTO_REFERENCIA) +
                                '/' +
                                $scope.filtro.referenciaProducto,
                                $cookies
                                .getObject(utils.PRUEBATECNICA_COOKIE).token);
                        resultadoRegistro
                            .then(
                                function(response) {

                                    $scope.movimientosFiltrados = response.data;

                                    if ($scope.movimientosFiltrados.length > 0) {

                                        $scope.producto.descripcion = $scope.movimientosFiltrados[0].descripcionProducto;
                                        $scope.producto.cantidadDisponible = $scope.movimientosFiltrados[0].cantidadDisponible;

                                    }

                                    AlertService
                                        .success("Movimientos consultados Correctamente");
                                },
                                function(error) {
                                    AlertService
                                        .error("Ocurrio un error consultando los movimientos");
                                });

                    } else {
                        AlertService
                            .warning("Los campos son obligatorios");
                    }

                };

            }

        ]);