'use strict';

angular
    .module('pruebaTecnicaApp')
    .controller(
        'RegistrarMovimientoController',
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

                $scope.movimiento = {
                    referenciaProducto: "",
                    cantidad: "",
                    descripcion: "",
                    tipo: ""
                };
                $scope.alertas = AlertService.get();

                $scope.resultadoTipos = [];
                $scope.resultadoReferencias = [];

                var consultarTiposMovimientos = function() {

                    var resultadoRegistro = apiClient
                        .doGet(
                            pathsFactory
                            .generatePath(endpoints.CONSULTAR_TIPOS_MOVIMIENTOS),
                            $cookies
                            .getObject(utils.PRUEBATECNICA_COOKIE).token);
                    resultadoRegistro
                        .then(
                            function(response) {

                                $scope.resultadoTipos = response.data;

                            },
                            function(error) {
                                AlertService
                                    .error("Ocurrio un error consultando los tipos de movimiento");
                            });
                };

                var consultarReferenciasProductos = function() {

                    var resultadoRegistro = apiClient
                        .doGet(
                            pathsFactory
                            .generatePath(endpoints.CONSULTAR_TODOS_PRODUCTOS),
                            $cookies
                            .getObject(utils.PRUEBATECNICA_COOKIE).token);
                    resultadoRegistro
                        .then(
                            function(response) {
                                $scope.resultadoReferencias = response.data;
                            },
                            function(error) {

                                AlertService
                                    .error("Ocurrio un error consultando las referencias de los productos");
                            });
                };

                $scope.registrarMovimiento = function() {

                    var requestObject = {};
                    if ($scope.movimiento.referenciaProducto !== undefined && $scope.movimiento.referenciaProducto !== "" &&
                        $scope.movimiento.cantidad !== undefined && $scope.movimiento.cantidad !== "" &&
                        $scope.movimiento.descripcion !== undefined && $scope.movimiento.descripcion !== "" &&
                        $scope.movimiento.tipo !== undefined && $scope.movimiento.tipo !== "") {

                        var requestObject = {
                            movimientoProducto: {
                                referenciaProducto: $scope.movimiento.referenciaProducto,
                                cantidad: $scope.movimiento.cantidad,
                                descripcionMovimiento: $scope.movimiento.descripcion,
                                tipoMovimiento: $scope.movimiento.tipo
                            }
                        };

                        var resultadoRegistro = apiClient
                            .doPost(
                                pathsFactory
                                .generatePath(endpoints.REGISTRAR_MOVIMIENTO),
                                requestObject,
                                $cookies
                                .getObject(utils.PRUEBATECNICA_COOKIE).token);
                        resultadoRegistro
                            .then(
                                function(response) {

                                    $scope.resultadoActualizacion = response.data;

                                    if (response.data.resultadoRegistro.errorResponse == true) {
                                        AlertService
                                            .error(response.data.resultadoRegistro.mensajeError);
                                    } else {

                                        AlertService
                                            .success("Movimiento Registrado Correctamente");
                                    }
                                },
                                function(error) {

                                    AlertService
                                        .error("Ocurrio un error registrando el movimiento");
                                });

                    } else {
                        AlertService
                            .warning("Los campos son obligatorios");
                    }

                };

                consultarTiposMovimientos();
                consultarReferenciasProductos();

            }

        ]);