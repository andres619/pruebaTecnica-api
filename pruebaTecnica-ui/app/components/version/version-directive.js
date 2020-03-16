'use strict';

angular.module('pruebaTecnicaApp.version.version-directive', [])

.directive('pruebaTecnicaApp', [ 'version', function(version) {
	return function(scope, elm, attrs) {
		elm.text(version);
	};
} ]);
