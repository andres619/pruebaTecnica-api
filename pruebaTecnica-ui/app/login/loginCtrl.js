'use strict';

angular
		.module('pruebaTecnicaApp')

		.controller(
				'LoginCtrl',
				[
						'$scope',
						'$state',
						'$cookies',
						'apiClient',
						'endpoints',
						'utils',
						'AlertService',
						'pathsFactory',
						function($scope, $state, $cookies, apiClient,
								endpoints, utils, AlertService, pathsFactory) {

							$scope.login = function() {
								AlertService.clear();
								apiClient
										.doPost(
												pathsFactory
														.generatePath(endpoints.LOGIN),
												$scope.user)
										.then(
												function(response) {
													if (response.data.token !== null) {
														$cookies
																.putObject(
																		utils.PRUEBATECNICA_COOKIE,
																		response.data);
														$state.go("app.home");
													} else {
														console
																.info('login failed');
														AlertService
																.error('El usuario o contraseña ingresados no son validos');
													}
												}, function(err) {
													console.info(err);
												});
							};

							$scope.registerCookie = function() {

							}

							$scope.init = function() {
								AlertService.clear();
								$scope.user = {};
								$scope.alertas = AlertService.get();
							};

							$scope.init();
						} ]);
