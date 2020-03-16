'use strict';

angular
    .module('pruebaTecnicaApp')
    .controller(
        'RegistrarProductoController',
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

                $scope.filtro = {
                    referenciaProducto: "",
                    descripcion: ""
                };
                $scope.alertas = AlertService.get();

                $scope.registrarProducto = function() {
                    var requestObject = {};
                    if ($scope.filtro.referenciaProducto !== undefined &&
                        $scope.filtro.referenciaProducto !== "" && $scope.filtro.descripcion !== undefined &&
                        $scope.filtro.descripcion !== "") {

                        var requestObject = {
                            producto: {
                            	descripcion: $scope.filtro.descripcion,
                                referencia: $scope.filtro.referenciaProducto
                            }
                        };

                        var resultadoRegistro = apiClient
                            .doPost(
                                pathsFactory
                                .generatePath(endpoints.REGISTRAR_PRODUCTO),
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
                                            .success("Producto Registrado Correctamente");
                                    }
                                },
                                function(error) {
                                    AlertService
                                        .error("Ocurrio un error registrando el producto");
                                });

                    } else {
                        AlertService
                            .warning("Los campos son obligatorios");
                    }

                };
            }

        ]);