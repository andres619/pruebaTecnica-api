'use strict';

/**
 * 
 * Servicios destinados a las peticiones HTTP al backend
 * 
 * @param {[type]}
 *            $http){ doGet [description]
 * @return {[type]} [description]
 */
angular.module('pruebaTecnicaApp.services', []).service('apiClient',
		[ '$http', '$q', function($http, $q) {

			this.tokenHeader = 'gsec-user-token';

			this.doGet = function(path, token) {
				var deferred = $q.defer();
				$http.defaults.headers.common[this.tokenHeader] = token;
				$http.get(path).then(function(response) {
					deferred.resolve(response);
				}, function(error) {
					deferred.reject(error);
				});

				return deferred.promise;
			};

			this.doPost = function(path, data, token) {
				var deferred = $q.defer();
				$http.defaults.headers.common['gsec-user-token'] = token;
				$http.post(path, data).then(function(response) {
					deferred.resolve(response);
				}, function(error) {
					deferred.reject(error);
				});

				return deferred.promise;
			};

			this.doPut = function(path, data, token) {
				var deferred = $q.defer();
				$http.defaults.headers.common['gsec-user-token'] = token;
				$http.put(path, data).then(function(response) {
					deferred.resolve(response);
				}, function(error) {
					deferred.reject(error);
				});

				return deferred.promise;
			};

		} ]);
